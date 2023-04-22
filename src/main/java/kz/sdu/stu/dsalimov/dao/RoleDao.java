package kz.sdu.stu.dsalimov.dao;


import kz.sdu.stu.dsalimov.dto.db.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleDao {
    @Select(//language=PostgreSQL
            "SELECT * FROM roles")
    List<Role> findAll();

    @Select(//language=PostgreSQL
            "SELECT * FROM roles WHERE uuid = #{uuid}")
    Role findByUuid(String uuid);

    @Insert(//language=PostgreSQL
            "INSERT INTO roles (uuid, title) VALUES (#{uuid}, #{title})")
    void insert(Role role);

    @Update(//language=PostgreSQL
            "UPDATE roles SET title = #{title} WHERE uuid = #{uuid}")
    void update(Role role);

    @Delete(//language=PostgreSQL
            "DELETE FROM roles WHERE uuid = #{uuid}")
    void deleteByUuid(String uuid);

    @Update(//language=PostgreSQL
            "UPDATE roles SET title = #{title} WHERE uuid = #{uuid}")
    void updateTitle(@Param("uuid") String uuid, @Param("title") String title);

}

