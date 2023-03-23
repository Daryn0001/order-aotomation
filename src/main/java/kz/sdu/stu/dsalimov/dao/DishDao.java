package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Dish;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DishDao {

    @Select(//language=PostgreSQL
            "SELECT uuid, title, description, pictures, ingredients, amount, notes, category_id AS categoryId FROM dish")
    List<Dish> getDishes();

    @Select(//language=PostgreSQL
            "SELECT uuid, title, description, pictures, ingredients, amount, notes, category_id AS categoryId FROM dish WHERE uuid = #{uuid}")
    Dish findById(String uuid);

    @Insert(//language=PostgreSQL
            "INSERT INTO dish (uuid, title, description, pictures, ingredients, amount, notes, body, category_id)" +
            " VALUES (#{uuid}, #{title}, #{description}, #{pictures}, #{ingredients}, #{amount}, #{notes}, #{body}, #{categoryId})")
    void insert(Dish dish);

    @Delete(//language=PostgreSQL
            "DELETE FROM dish WHERE uuid = #{uuid}")
    void delete(String uuid);


    @Update(//language=PostgreSQL
            "UPDATE dish " +
            "SET title = #{dish.title}," +
            "description = #{dish.description}," +
            "pictures = #{dish.pictures}," +
            "ingredients = #{dish.ingredients}," +
            "amount = #{dish.amount}," +
            "notes = #{dish.notes}," +
            "body = #{dish.body}," +
            "category_id = #{dish.categoryId} " +
            "WHERE uuid = #{dishUuid}")
    void update(String dishUuid, Dish dish);

    @Update(//language=PostgreSQL
            "UPDATE dish SET title = #{title} WHERE uuid = #{uuid}")
    void updateTitle(String uuid, String title);

    @Update(//language=PostgreSQL
            "UPDATE dish SET description = #{description} WHERE uuid = #{uuid}")
    void updateDescription(String uuid, String description);

    @Update(//language=PostgreSQL
            "UPDATE dish SET pictures = #{pictures} WHERE uuid = #{uuid}")
    void updatePicture(String uuid, String pictures);

    @Update(//language=PostgreSQL
            "UPDATE dish SET ingredients = #{ingredients} WHERE uuid = #{uuid}")
    void updateIngredients(String uuid, String ingredients);

    @Update(//language=PostgreSQL
            "UPDATE dish SET amount = #{amount} WHERE uuid = #{uuid}")
    void updateAmount(String uuid, int amount);

    @Update(//language=PostgreSQL
            "UPDATE dish SET notes = #{notes} WHERE uuid = #{uuid}")
    void updateNote(String uuid, String notes);

    @Update(//language=PostgreSQL
            "UPDATE dish SET body = #{body} WHERE uuid = #{uuid}")
    void updateBody(String uuid, String body);

    @Update(//language=PostgreSQL
            "UPDATE dish SET category_id = #{category_id} WHERE uuid = #{uuid}")
    void updateCategoryId(String uuid, int category_id);
}
