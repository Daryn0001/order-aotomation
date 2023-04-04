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
public interface TableDao {
    @Select("SELECT uuid, floor, internal_id as internalId, temporary_key as temporaryKey FROM tables")
    List<TableDetails> getTables();

    @Select("select * from tables where uuid = #{uuid}")
    TableDetails findById(String uuid);

    @Insert("INSERT INTO tables (uuid, floor, internal_id, temporary_key) VALUES (#{uuid}, #{floor}, #{internalId}, #{temporaryKey})")
    String insert(TableDetails table);

    @Delete("DELETE FROM tables WHERE uuid = #{uuid}")
    boolean delete(String uuid);
}
