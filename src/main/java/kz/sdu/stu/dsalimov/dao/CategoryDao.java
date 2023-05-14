package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Category;
import kz.sdu.stu.dsalimov.dto.filter.DishFilter;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.postgresql.util.PGobject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryDao {
    @Select(//language=PostgreSQL
            "SELECT id, parent_category_id as parentCategoryId, name, description, image FROM categories")
    List<Category> getCategories();

    @Select(//language=PostgreSQL
            "SELECT id, parent_category_id as parentCategoryId, name, description, image FROM categories where id = #{id}")
    Category findById(int id);

    @SelectProvider(value = CategoryProvider.class, method = "getCategoriesByFilter")
    List<Category> getCategoriesByFilter(@Param("filter") DishFilter filter);

    @Select(//language=PostgreSQL
            "select count(*) from dishes join categories c on dishes.category_id = c.id where category_id = #{categoryId}")
    int getDishCountFromCategory(@Param("categoryId") int categoryId);

    @Insert(//language=PostgreSQL
            "INSERT INTO categories ( parent_category_id, name, description, image)" +
                    " VALUES ( #{category.parentCategoryId}, #{category.name}, #{category.description}, #{image})")
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
        public String getCategoriesByFilter(@Param("filter") DishFilter filter) {
            System.out.println("NOttNNPqmqRm :: filter from category dao: " + filter);
            SQL sql = new SQL();

            int offset = filter.getOffset() * filter.getLimit();

            SQL query = baseQuery(sql);

            if (filter.getSearchText() != null && !filter.getSearchText().isBlank()) {
                String searchText = "%" + filter.getSearchText() + "%";
                String search = String.format("name ILIKE '%s'", searchText);
                query.WHERE(search);
            }
            if (filter.getDirection() != null && !filter.getDirection().isBlank()) {
                query.ORDER_BY("name " + filter.getDirection());
            } else {
                query.ORDER_BY("name asc");
            }

            query.LIMIT(filter.getLimit())
                    .OFFSET(offset);

            System.out.println("J58NoZ7 :: SQL filter query: " + query);
            return query.toString();
        }

        private SQL baseQuery(SQL sql) {
            return sql.SELECT(" id, parent_category_id as parentCategoryId, name, description, image")
                    .FROM("categories");

        }
    }
}
