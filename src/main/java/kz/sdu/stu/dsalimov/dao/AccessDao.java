package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Access;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccessDao {
    @Select(//language=PostgreSQL
            "SELECT * FROM accesses")
    List<Access> findAll();

    @Select(//language=PostgreSQL
            "SELECT * FROM accesses WHERE id = #{id}")
    Access findById(int id);

    @Insert(//language=PostgreSQL
            "INSERT INTO accesses (branch_uuid, user_uuid) VALUES (#{branchUuid}, #{userUuid})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Access access);

    @Update(//language=PostgreSQL
            "UPDATE accesses SET branch_uuid = #{branchUuid}, user_uuid = #{userUuid} WHERE id = #{id}")
    void update(Access access);

    @Delete(//language=PostgreSQL
            "DELETE FROM accesses WHERE id = #{id}")
    void deleteById(int id);

    @Update(//language=PostgreSQL
            "UPDATE accesses SET branch_uuid = #{branchUuid} WHERE id = #{id}")
    void updateBranchUuid(@Param("id") int id, @Param("branchUuid") String branchUuid);

    @Update(//language=PostgreSQL
            "UPDATE accesses SET user_uuid = #{userUuid} WHERE id = #{id}")
    void updateUserUuid(@Param("id") int id, @Param("userUuid") String userUuid);

}
