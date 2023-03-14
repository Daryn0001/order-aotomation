package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.OrderDetails;
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
    @Select("SELECT * FROM order_details")
    List<OrderDetails> getTables();

    @Select("select * from order_details where uuid = #{uuid}")
    OrderDetails findById(String uuid);

    @Insert("INSERT INTO order_details (uuid, floor, internalId, temporaryKey) VALUES (#{uuid}, #{floor}, #{internalId}, #{temporaryKey})")
    void insert(OrderDetails table);

    @Delete("DELETE FROM order_details WHERE uuid = #{uuid}")
    void delete(String uuid);
}
