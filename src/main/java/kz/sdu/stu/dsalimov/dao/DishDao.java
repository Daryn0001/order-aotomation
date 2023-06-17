package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Dish;
import kz.sdu.stu.dsalimov.dto.filter.SearchFilter;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.postgresql.util.PGobject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DishDao {

    @Select(//language=PostgreSQL
            "SELECT uuid, title, description, pictures, ingredients, amount, notes, price, is_active as isActive," +
                    " category_id AS categoryId FROM dishes")
    List<Dish> getDishes();

    @Select(//language=PostgreSQL
            "SELECT uuid, title, description, pictures, ingredients, amount, notes, price, is_active as isActive," +
                    " category_id AS categoryId FROM dishes WHERE uuid = #{uuid}")
    Dish findById(String uuid);

    @Select(//language=PostgreSQL
            "with dishUuid as (select dish_uuid from elements join events e on e.uuid = elements.event_uuid where event_uuid = #{eventUuid})\n" +
                    "select * from dishes where uuid in  (select * from dishUuid) ; ")
    List<Dish> getDishesByEvent(String eventUuid);

    @SelectProvider(value = DishProvider.class, method = "getDishesByFilter")
    List<Dish> getDishesByFilter(@Param("filter") SearchFilter filter);

    @Select(//language=PostgreSQL
            "SELECT uuid, title, description, pictures, ingredients, amount, notes, price, is_active as isActive, category_id AS categoryId" +
                    " FROM dishes WHERE category_id = #{categoryId}")
    List<Dish> getDishesByCategory(@Param("categoryId") int categoryId);

    @Insert(//language=PostgreSQL
            "INSERT INTO dishes (uuid, title, description, pictures, ingredients, amount,  notes, price, is_active,  category_id)" +
                    " VALUES (#{dish.uuid}, #{dish.title}, #{dish.description}, #{pictures}, #{dishIngredients}, #{dish.amount}, #{dish.notes}, #{dish.price}, #{dish.isActive}, #{dish.categoryId})")
    void insert(Dish dish, PGobject dishIngredients, PGobject pictures);

    @Delete(//language=PostgreSQL
            "DELETE FROM dishes WHERE uuid = #{uuid}")
    void delete(String uuid);

    @Update(//language=PostgreSQL
            "UPDATE dishes " +
                    "SET title = #{dish.title}," +
                    "description = #{dish.description}," +
                    "pictures = #{dish.pictures}," +
                    "ingredients = #{dish.ingredients}," +
                    "amount = #{dish.amount}," +
                    "notes = #{dish.notes}," +
                    "price = #{dish.price}," +
                    "is_active = #{dish.isActive}," +
                    "category_id = #{dish.categoryId} " +
                    "WHERE uuid = #{dishUuid}")
    void update(String dishUuid, Dish dish);

    @Update(//language=PostgreSQL
            "UPDATE dishes SET title = #{title} WHERE uuid = #{uuid}")
    void updateTitle(String uuid, String title);

    @Update(//language=PostgreSQL
            "UPDATE dishes SET description = #{description} WHERE uuid = #{uuid}")
    void updateDescription(String uuid, String description);

    @Update(//language=PostgreSQL
            "UPDATE dishes SET pictures = #{pictures} WHERE uuid = #{uuid}")
    void updatePicture(String uuid, String pictures);

    @Update(//language=PostgreSQL
            "UPDATE dishes SET ingredients = #{ingredients} WHERE uuid = #{uuid}")
    void updateIngredients(String uuid, String ingredients);

    @Update(//language=PostgreSQL
            "UPDATE dishes SET amount = #{amount} WHERE uuid = #{uuid}")
    void updateAmount(String uuid, int amount);

    @Update(//language=PostgreSQL
            "UPDATE dishes SET notes = #{notes} WHERE uuid = #{uuid}")
    void updateNote(String uuid, String notes);

    @Update(//language=PostgreSQL
            "UPDATE dishes SET price = #{price} WHERE uuid = #{uuid}")
    void updatePrice(String uuid, int price);

    @Update(//language=PostgreSQL
            "UPDATE dishes SET is_active = #{isActive} WHERE uuid = #{uuid}")
    void updateIsActive(String uuid, boolean isActive);

    @Update(//language=PostgreSQL
            "UPDATE dishes SET category_id = #{category_id} WHERE uuid = #{uuid}")
    void updateCategoryId(String uuid, int category_id);

    class DishProvider {
        public String getDishesByFilter(@Param("filter") SearchFilter filter) {
            System.out.println("R6H134o :: filter from dao: " + filter);
            SQL sql = new SQL();

            int offset = filter.getOffset() * filter.getLimit();

            SQL query = baseQuery(sql);

            if (filter.getSearchText() != null && !filter.getSearchText().isBlank()) {
                String searchText = "%" + filter.getSearchText() + "%";
                String search = String.format("title ILIKE '%s'", searchText);
                query.WHERE(search);
            }
            query.ORDER_BY("title asc");

            query.LIMIT(filter.getLimit())
                    .OFFSET(offset);

            System.out.println("J58NoZ7 :: SQL filter query: " + query);
            return query.toString();
        }

        private SQL baseQuery(SQL sql) {
            return sql.SELECT("uuid,\n" +
                            "       title,\n" +
                            "       description,\n" +
                            "       pictures,\n" +
                            "       ingredients,\n" +
                            "       amount,\n" +
                            "       notes,\n" +
                            "       price,\n" +
                            "       is_active   as isActive,\n" +
                            "       category_id AS categoryId")
                    .FROM("dishes");

        }
    }
}
