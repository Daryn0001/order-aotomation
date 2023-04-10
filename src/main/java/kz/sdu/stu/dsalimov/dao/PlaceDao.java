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
            "INSERT INTO place (uuid, name, slug) VALUES (#{uuid}, #{name}, #{slug})")
    void insert(Place place);

    @Update(//language=PostgreSQL
            "UPDATE place SET name = #{name}, slug = #{slug} WHERE uuid = #{uuid}")
    void update(Place place);

    @Delete(//language=PostgreSQL
            "DELETE FROM place WHERE uuid = #{uuid}")
    void deleteByUuid(String uuid);

    @Update(//language=PostgreSQL
            "UPDATE place SET name = #{name} WHERE uuid = #{uuid}")
    void updateName(@Param("uuid") String uuid, @Param("name") String name);

    @Update(//language=PostgreSQL
            "UPDATE place SET slug = #{slug} WHERE uuid = #{uuid}")
    void updateSlug(@Param("uuid") String uuid, @Param("slug") String slug);

}
