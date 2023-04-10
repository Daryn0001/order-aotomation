package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Event;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EventDao {
    @Select("SELECT * FROM event")
    List<Event> findAll();

    @Select("SELECT * FROM event WHERE uuid = #{uuid}")
    Event findByUuid(String uuid);

    @Insert("INSERT INTO event (uuid, title, description, body, places_uuid) VALUES (#{uuid}, #{title}, #{description}, #{body}, #{placeUuid})")
    void insert(Event event);

    @Update("UPDATE event SET title = #{title}, description = #{description}, body = #{body}, places_uuid = #{placeUuid} WHERE uuid = #{uuid}")
    void update(Event event);

    @Delete("DELETE FROM event WHERE uuid = #{uuid}")
    void deleteByUuid(String uuid);

    @Update("UPDATE event SET title = #{title} WHERE uuid = #{uuid}")
    void updateTitle(@Param("uuid") String uuid, @Param("title") String title);

    @Update("UPDATE event SET description = #{description} WHERE uuid = #{uuid}")
    void updateDescription(@Param("uuid") String uuid, @Param("description") String description);

    @Update("UPDATE event SET body = #{body} WHERE uuid = #{uuid}")
    void updateBody(@Param("uuid") String uuid, @Param("body") String body);

    @Update("UPDATE event SET places_uuid = #{placeUuid} WHERE uuid = #{uuid}")
    void updatePlaceUuid(@Param("uuid") String uuid, @Param("placeUuid") String placeUuid);

}
