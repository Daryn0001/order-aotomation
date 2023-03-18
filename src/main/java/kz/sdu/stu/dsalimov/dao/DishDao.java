package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Dish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DishDao {

    @Select("SELECT uuid, title, description, pictures, ingredients, amount, notes, category_id AS categoryId FROM dish")
    List<Dish> getDishes();

    @Select("SELECT uuid, title, description, pictures, ingredients, amount, notes, category_id AS categoryId FROM dish WHERE uuid = #{uuid}")
    Dish findById(String uuid);

    @Insert("INSERT INTO dish (uuid, title, description, pictures, ingredients, amount, notes, body, category_id)" +
            " VALUES (#{uuid}, #{title}, #{description}, #{pictures}, #{ingredients}, #{amount}, #{notes}, #{body}, #{categoryId})")
    void insert(Dish dish);

    @Delete("DELETE FROM dish WHERE uuid = #{uuid}")
    void delete(String uuid);
}
