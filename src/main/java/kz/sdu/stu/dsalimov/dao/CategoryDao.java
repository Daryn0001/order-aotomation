package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryDao {
    @Select("SELECT id, parent_category_id as parentCategoryId, name, description FROM category")
    List<Category> getCategories();

    @Select("SELECT id, parent_category_id as parentCategoryId, name, description FROM category where id = #{id}")
    Category findById(int id);

    @Insert("INSERT INTO category ( parent_category_id, name, description)" +
            " VALUES ( #{parentCategoryId}, #{name}, #{description})")
    void insert(Category category);

    @Delete("DELETE FROM category WHERE id = #{id}")
    void delete(int id);


}
