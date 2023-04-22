package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Element;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ElementDao {
    @Select(//language=PostgreSQL
            "SELECT * FROM elements")
    List<Element> findAll();

    @Select(//language=PostgreSQL
            "SELECT * FROM elements WHERE uuid = #{uuid}")
    Element findByUuid(String uuid);

    @Insert(//language=PostgreSQL
            "INSERT INTO elements (uuid, dish_uuid, event_uuid) VALUES (#{uuid}, #{dishUuid}, #{eventUuid})")
    void insert(Element element);

    @Update(//language=PostgreSQL
            "UPDATE elements SET dish_uuid = #{dishUuid}, event_uuid = #{eventUuid} WHERE uuid = #{uuid}")
    void update(Element element);

    @Delete(//language=PostgreSQL
            "DELETE FROM elements WHERE uuid = #{uuid}")
    void deleteByUuid(String uuid);

    @Update(//language=PostgreSQL
            "UPDATE elements SET dish_uuid = #{dishUuid} WHERE uuid = #{uuid}")
    void updateDishUuid(@Param("uuid") String uuid, @Param("dishUuid") String dishUuid);

    @Update(//language=PostgreSQL
            "UPDATE elements SET event_uuid = #{eventUuid} WHERE uuid = #{uuid}")
    void updateEventUuid(@Param("uuid") String uuid, @Param("eventUuid") String eventUuid);

}
