package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Table;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TableDao {
    @Select(//language=PostgreSQL
            "SELECT uuid, internal_id as internalId, temporary_key as temporaryKey, branch_uuid as branchUuid FROM tables")
    List<Table> findAll();

    @Select(//language=PostgreSQL
            "select  uuid, internal_id as internalId, temporary_key as temporaryKey, branch_uuid as branchUuid from tables where uuid = #{uuid}")
    Table findById(String uuid);

    @Select(//language=PostgreSQL
            "select  uuid, internal_id as internalId, temporary_key as temporaryKey, branch_uuid as branchUuid from tables " +
                    "where temporary_key = #{temporary_key}")
    Table findByTempKey(String temporaryKey);

    @Insert(//language=PostgreSQL
            "INSERT INTO tables (uuid,  internal_id, temporary_key, branch_uuid) VALUES (#{uuid}, #{internalId}, #{temporaryKey}, #{branchUuid})")
    String insert(Table table);

    @Delete(//language=PostgreSQL
            "DELETE FROM tables WHERE uuid = #{uuid}")
    boolean delete(String uuid);

    @Update(//language=PostgreSQL
            "UPDATE tables SET internal_id = #{internalId} WHERE uuid = #{uuid}")
    void updateInternalId(@Param("uuid") String uuid, @Param("internalId") String internalId);

    @Update(//language=PostgreSQL
            "UPDATE tables SET temporary_key = #{temporaryKey} WHERE uuid = #{uuid}")
    void updateTemporaryKey(@Param("uuid") String uuid, @Param("temporaryKey") String temporaryKey);

    @Update(//language=PostgreSQL
            "UPDATE tables SET branch_uuid = #{branchUuid} WHERE uuid = #{uuid}")
    void updateBranchUuid(@Param("uuid") String uuid, @Param("branchUuid") String branchUuid);

}
