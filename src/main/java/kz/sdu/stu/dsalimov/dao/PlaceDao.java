package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Place;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlaceDao {
    @Select(//language=PostgreSQL
            "SELECT  uuid, type, name, size, branch_uuid as branchUuid FROM places")
    List<Place> findAll();

    @Select(//language=PostgreSQL
            "SELECT uuid, type, name, size, branch_uuid as branchUuid FROM places WHERE uuid = #{uuid}")
    Place findByUuid(String uuid);

    @Select(//language=PostgreSQL
            "SELECT  uuid, type, name, size, branch_uuid as branchUuid FROM places WHERE branch_Uuid = #{branchUuid} " )
    List<Place> findByBranchUuid(String branchUuid);

    @Insert(//language=PostgreSQL
            "INSERT INTO places (uuid, type, name, size, branch_uuid) VALUES (#{uuid}, #{type}, #{name}, #{size}, #{branchUuid})")
    void insert(Place place);

    @Update(//language=PostgreSQL
            "UPDATE places SET type = #{place.type}, size = #{place.size}, name = #{place.name} WHERE uuid = #{place_uuid}")
    void update(String place_uuid, Place place);

    @Delete(//language=PostgreSQL
            "DELETE FROM places WHERE uuid = #{uuid}")
    void deleteByUuid(String uuid);

    @Update(//language=PostgreSQL
            "UPDATE places SET type = #{type} WHERE uuid = #{uuid}")
    void updateType(@Param("uuid") String uuid, @Param("type") String type);

    @Update(//language=PostgreSQL
            "UPDATE places SET size = #{size} WHERE uuid = #{uuid}")
    void updateSize(@Param("uuid") String uuid, @Param("size") String size);


    @Update(//language=PostgreSQL
            "UPDATE places SET name = #{name} WHERE uuid = #{uuid}")
    void updateName(@Param("uuid") String uuid, @Param("name") String name);
}
