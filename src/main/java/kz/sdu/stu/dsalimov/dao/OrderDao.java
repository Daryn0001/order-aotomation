package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.TableDetails;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDao {

    @Select("SELECT * FROM order_details")
    List<TableDetails> getTables();

    @Select("select * from order_details where uuid = #{uuid}")
    TableDetails findById(String uuid);

    @Insert("INSERT INTO order_details (uuid, floor, internalId, temporaryKey) VALUES (#{uuid}, #{floor}, #{internalId}, #{temporaryKey})")
    String insert(TableDetails table);

    @Delete("DELETE FROM order_details WHERE uuid = #{uuid}")
    boolean delete(String uuid);
}
