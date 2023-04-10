package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Orders;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDao {
// FIXME
    @Select("SELECT * FROM orders")
    List<Orders> getTables();

    @Select("select * from orders where uuid = #{uuid}")
    Orders findById(String uuid);

    @Insert("INSERT INTO orders (uuid, floor, internalId, temporaryKey) VALUES (#{uuid}, #{floor}, #{internalId}, #{temporaryKey})")
    void insert(Orders table);

    @Delete("DELETE FROM orders WHERE uuid = #{uuid}")
    void delete(String uuid);
}
