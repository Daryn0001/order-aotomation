package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.BasketDto;
import kz.sdu.stu.dsalimov.dto.db.Tables;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BasketDao {
    @Select(//language=PostgreSQL
            "SELECT uuid, amount, dish_uuid as dishUuid, order_uuid as orderUuid, price FROM baskets")
    List<BasketDto> getBaskets();

    @Select(//language=PostgreSQL
            "select uuid, amount, dish_uuid as dishUuid, order_uuid as orderUuid, price from baskets where uuid = #{uuid}")
    BasketDto findById(String uuid);

    @Insert(//language=PostgreSQL
            "INSERT INTO baskets (uuid, amount, dish_uuid, order_uuid, price) VALUES (#{uuid}, #{amount}, #{dishUuid}, #{orderUuid}, #{price})")
    void insert(BasketDto basketDto);

    @Delete(//language=PostgreSQL
            "DELETE FROM baskets WHERE uuid = #{uuid}")
    boolean delete(String uuid);

    @Update(//language=PostgreSQL
            "UPDATE baskets SET amount = #{amount} WHERE uuid = #{uuid}")
    void updateAmount(String uuid, int amount);

    @Update(//language=PostgreSQL
            "UPDATE baskets SET dish_uuid = #{dishUuid} WHERE uuid = #{uuid}")
    void updateDishUuid(String uuid, String dishUuid);

    @Update(//language=PostgreSQL
            "UPDATE baskets SET order_uuid = #{orderUuid} WHERE uuid = #{uuid}")
    void updateOrderUuid(String uuid, String orderUuid);

    @Update(//language=PostgreSQL
            "UPDATE baskets SET price = #{price} WHERE uuid = #{uuid}")
    void updatePrice(String uuid, int price);
}
