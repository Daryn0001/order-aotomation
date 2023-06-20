package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Category;
import kz.sdu.stu.dsalimov.dto.filter.SearchFilter;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.postgresql.util.PGobject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryDao {
    @Select(//language=PostgreSQL
            "SELECT id, parent_category_id as parentCategoryId, c.name, description, image, branch_uuid as branchUuid FROM categories c JOIN branches b on c.branch_uuid = b.uuid " +
                    "where c.branch_uuid = #{branchId}")
    List<Category> getCategories(String branchId);

    @Select(//language=PostgreSQL
            "SELECT id, parent_category_id as parentCategoryId, name, description, image, branch_uuid as branchUuid FROM categories where id = #{id}")
    Category findById(int id);

    @SelectProvider(value = CategoryProvider.class, method = "getCategoriesByFilter")
    List<Category> getCategoriesByFilter(@Param("filter") SearchFilter filter, @Param("branchUuid") String branchUuid);

    @Select(//language=PostgreSQL
            "select count(*) from dishes join categories c on dishes.category_id = c.id where category_id = #{categoryId}")
    int getDishCountFromCategory(@Param("categoryId") int categoryId);

    @Insert(//language=PostgreSQL
            "INSERT INTO categories ( parent_category_id, name, description, image, branch_uuid)" +
                    " VALUES ( #{category.parentCategoryId}, #{category.name}, #{category.description}, #{image}, #{category.branchId})")
    void insert(Category category, PGobject image);

    @Delete(//language=PostgreSQL
            "DELETE FROM categories WHERE id = #{id}")
    void delete(int id);

    @Update(//language=PostgreSQL
            "UPDATE categories SET parent_category_id = #{category.parentCategoryId}," +
                    " name = #{category.name}," +
                    " description = #{category.description}" +
                    " WHERE id = #{id}")
    void update(int id, Category category);

    @Update(//language=PostgreSQL
            "UPDATE categories SET parent_category_id = #{parentCategoryId} WHERE id = #{id}")
    void updateParentCategoryId(int id, int parentCategoryId);

    @Update(//language=PostgreSQL
            "UPDATE categories SET name = #{name} WHERE id = #{id}")
    void updateName(int id, String name);

    @Update(//language=PostgreSQL
            "UPDATE categories SET description = #{description} WHERE id = #{id}")
    void updateDescription(int id, String description);

    class CategoryProvider {
        public String getCategoriesByFilter(@Param("filter") SearchFilter filter, @Param("branchUuid") String branchUuid) {
            System.out.println("NOttNNPqmqRm :: filter from category dao: " + filter);
            SQL sql = new SQL();

            int offset = filter.getOffset() * filter.getLimit();

            SQL query = baseQuery(sql, branchUuid);

            if (filter.getSearchText() != null && !filter.getSearchText().isBlank()) {
                String searchText = "%" + filter.getSearchText() + "%";
                String search = String.format("c.name ILIKE '%s'", searchText);
                query.WHERE(search);
            }
            if (filter.getDirection() != null && !filter.getDirection().isBlank()) {
                query.ORDER_BY("c.name " + filter.getDirection());
            } else {
                query.ORDER_BY("c.name asc");
            }

            query.LIMIT(filter.getLimit())
                    .OFFSET(offset);

            System.out.println("J58NoZ7 :: SQL filter query: " + query);
            return query.toString();
        }

        private SQL baseQuery(SQL sql, String branchId) {
            return sql.SELECT(" id, parent_category_id as parentCategoryId, c.name, description, image")
                    .FROM("categories c join branches b on c.branch_uuid = b.uuid")
                    .WHERE("c.branch_uuid = '" + branchId + "'");

        }
    }
}
