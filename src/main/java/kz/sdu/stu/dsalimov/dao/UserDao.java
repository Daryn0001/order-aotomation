package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    @Select(//language=PostgreSQL
            "SELECT * FROM users")
    List<User> findAll();

    @Select(//language=PostgreSQL
            "SELECT * FROM users WHERE uuid = #{uuid}")
    User findByUuid(String uuid);

    @Insert(//language=PostgreSQL
            "INSERT INTO users (uuid, fullname, phone, password, email, role_uuid) VALUES (#{uuid}, #{fullname}, #{phone}, #{password}, #{email}, #{roleUuid})")
    void insert(User user);

    @Update(//language=PostgreSQL
            "UPDATE users SET fullname = #{fullname}, phone = #{phone}, password = #{password}, email = #{email}, role_uuid = #{roleUuid} WHERE uuid = #{uuid}")
    void update(User user);

    @Delete(//language=PostgreSQL
            "DELETE FROM users WHERE uuid = #{uuid}")
    void deleteByUuid(String uuid);

    @Update(//language=PostgreSQL
            "UPDATE users SET fullname = #{fullname} WHERE uuid = #{uuid}")
    void updateFullname(@Param("uuid") String uuid, @Param("fullname") String fullname);

    @Update(//language=PostgreSQL
            "UPDATE users SET phone = #{phone} WHERE uuid = #{uuid}")
    void updatePhone(@Param("uuid") String uuid, @Param("phone") String phone);

    @Update(//language=PostgreSQL
            "UPDATE users SET password = #{password} WHERE uuid = #{uuid}")
    void updatePassword(@Param("uuid") String uuid, @Param("password") String password);

    @Update(//language=PostgreSQL
            "UPDATE users SET email = #{email} WHERE uuid = #{uuid}")
    void updateEmail(@Param("uuid") String uuid, @Param("email") String email);

    @Update(//language=PostgreSQL
            "UPDATE users SET role_uuid = #{roleUuid} WHERE uuid = #{uuid}")
    void updateRoleUuid(@Param("uuid") String uuid, @Param("roleUuid") String roleUuid);

}
