package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.OrderDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDao {
    @Select(//language=PostgreSQL
            "SELECT uuid, phone, name, table_uuid as tableUuid, price FROM orders")
    List<OrderDto> getTables();

    @Select(//language=PostgreSQL
            "select uuid, phone, name, table_uuid as tableUuid, price from orders where uuid = #{uuid}")
    OrderDto findById(String uuid);

    @Insert(//language=PostgreSQL
            "INSERT INTO orders ( uuid, phone, name, table_uuid, price ) VALUES (#{uuid}, #{phone}, #{name}, #{tableUuid}, #{price})")
    void insert(OrderDto table);

    @Delete(//language=PostgreSQL
            "DELETE FROM orders WHERE uuid = #{uuid}")
    void delete(String uuid);
}
