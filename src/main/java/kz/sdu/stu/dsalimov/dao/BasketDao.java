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
            "SELECT * FROM basket")
    List<Tables> getTables();

    @Select(//language=PostgreSQL
            "select * from basket where uuid = #{uuid}")
    Tables findById(String uuid);

    @Insert(//language=PostgreSQL
            "INSERT INTO basket (uuid, amount, dish_uuid, order_uuid) VALUES (#{uuid}, #{amount}, #{dishUuid}, #{orderUuid})")
    void insert(BasketDto basketDto);

    @Delete(//language=PostgreSQL
            "DELETE FROM basket WHERE uuid = #{uuid}")
    boolean delete(String uuid);

    @Update(//language=PostgreSQL
            "UPDATE basket SET amount = #{amount} WHERE uuid = #{uuid}")
    void updateAmount(String uuid, int amount);

    @Update(//language=PostgreSQL
            "UPDATE basket SET dish_uuid = #{dishUuid} WHERE uuid = #{uuid}")
    void updateDishUuid(String uuid, String dishUuid);

    @Update(//language=PostgreSQL
            "UPDATE basket SET order_uuid = #{orderUuid} WHERE uuid = #{uuid}")
    void updateOrderUuid(String uuid, String orderUuid);
}
