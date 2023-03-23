package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryDao {
    @Select(//language=PostgreSQL
            "SELECT id, parent_category_id as parentCategoryId, name, description FROM category")
    List<Category> getCategories();

    @Select(//language=PostgreSQL
            "SELECT id, parent_category_id as parentCategoryId, name, description FROM category where id = #{id}")
    Category findById(int id);

    @Insert(//language=PostgreSQL
            "INSERT INTO category ( parent_category_id, name, description)" +
                    " VALUES ( #{parentCategoryId}, #{name}, #{description})")
    void insert(Category category);

    @Delete(//language=PostgreSQL
            "DELETE FROM category WHERE id = #{id}")
    void delete(int id);

    @Update(//language=PostgreSQL
            "UPDATE category SET parent_category_id = #{category.parentCategoryId}," +
                    " name = #{category.name}," +
                    " description = #{category.description}" +
                    " WHERE id = #{id}")
    void update(int id, Category category);

    @Update(//language=PostgreSQL
            "UPDATE category SET parent_category_id = #{parentCategoryId} WHERE id = #{id}")
    void updateParentCategoryId(int id, int parentCategoryId);

    @Update(//language=PostgreSQL
            "UPDATE category SET name = #{name} WHERE id = #{id}")
    void updateName(int id, String name);

    @Update(//language=PostgreSQL
            "UPDATE category SET description = #{description} WHERE id = #{id}")
    void updateDescription(int id, String description);
}
