package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Place;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlaceDao {
    @Select(//language=PostgreSQL
            "SELECT * FROM place")
    List<Place> findAll();

    @Select(//language=PostgreSQL
            "SELECT * FROM place WHERE uuid = #{uuid}")
    Place findByUuid(String uuid);

    @Insert(//language=PostgreSQL
            "INSERT INTO place (uuid, type, size) VALUES (#{uuid}, #{type}, #{size})")
    void insert(Place place);

    @Update(//language=PostgreSQL
            "UPDATE place SET type = #{type}, size = #{size} WHERE uuid = #{uuid}")
    void update(Place place);

    @Delete(//language=PostgreSQL
            "DELETE FROM place WHERE uuid = #{uuid}")
    void deleteByUuid(String uuid);

    @Update(//language=PostgreSQL
            "UPDATE place SET type = #{type} WHERE uuid = #{uuid}")
    void updateType(@Param("uuid") String uuid, @Param("type") String type);

    @Update(//language=PostgreSQL
            "UPDATE place SET size = #{size} WHERE uuid = #{uuid}")
    void updateSize(@Param("uuid") String uuid, @Param("size") String size);

}
