package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.AccessDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccessDao {
    @Select(//language=PostgreSQL
            "SELECT branch_uuid, user_id as userId FROM accesses")
    List<AccessDto> findAll();

    @Select(//language=PostgreSQL
            "SELECT branch_uuid, user_id as userId FROM accesses WHERE id = #{id}")
    AccessDto findById(int id);

    @Insert(//language=PostgreSQL
            "INSERT INTO accesses (branch_uuid, user_id) VALUES (#{branchUuid}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(AccessDto access);

    @Update(//language=PostgreSQL
            "UPDATE accesses SET branch_uuid = #{branchUuid}, user_id = #{userId} WHERE id = #{id}")
    void update(AccessDto access);

    @Delete(//language=PostgreSQL
            "DELETE FROM accesses WHERE id = #{id}")
    void deleteById(int id);

    @Update(//language=PostgreSQL
            "UPDATE accesses SET branch_uuid = #{branchUuid} WHERE id = #{id}")
    void updateBranchUuid(@Param("id") int id, @Param("branchUuid") String branchUuid);

    @Update(//language=PostgreSQL
            "UPDATE accesses SET user_id = #{userId} WHERE id = #{id}")
    void updateUserUuid(@Param("id") int id, @Param("userId") Long userId);

}
