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
            "SELECT * FROM users WHERE id = #{id}")
    User findByUuid(Long id);

    @Insert(//language=PostgreSQL
            "INSERT INTO users (fullname, phone, password, email, remember_token) VALUES (#{fullname}, #{phone}, #{password}, #{email}, #{rememberToken})")
    void insert(User user);

    @Update(//language=PostgreSQL
            "UPDATE users SET fullname = #{fullname}, phone = #{phone}, password = #{password}, email = #{email} WHERE id = #{id}")
    void update(User user);

    @Delete(//language=PostgreSQL
            "DELETE FROM users WHERE id = #{id}")
    void deleteByUuid(Long id);

    @Update(//language=PostgreSQL
            "UPDATE users SET fullname = #{fullname} WHERE id = #{id}")
    void updateFullname(@Param("id") Long id, @Param("fullname") String fullname);

    @Update(//language=PostgreSQL
            "UPDATE users SET phone = #{phone} WHERE id = #{id}")
    void updatePhone(@Param("id") Long id, @Param("phone") String phone);

    @Update(//language=PostgreSQL
            "UPDATE users SET password = #{password} WHERE id = #{id}")
    void updatePassword(@Param("id") Long id, @Param("password") String password);

    @Update(//language=PostgreSQL
            "UPDATE users SET email = #{email} WHERE id = #{id}")
    void updateEmail(@Param("id") Long id, @Param("email") String email);

}
