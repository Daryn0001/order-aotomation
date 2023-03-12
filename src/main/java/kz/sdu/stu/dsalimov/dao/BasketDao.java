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
public interface BasketDao {
    @Select("SELECT * FROM basket")
    List<TableDetails> getTables();

    @Select("select * from basket where uuid = #{uuid}")
    TableDetails findById(String uuid);

    @Insert("INSERT INTO basket (uuid, floor, internalId, temporaryKey) VALUES (#{uuid}, #{floor}, #{internalId}, #{temporaryKey})")
    String insert(TableDetails table);

    @Delete("DELETE FROM basket WHERE uuid = #{uuid}")
    boolean delete(String uuid);
}
