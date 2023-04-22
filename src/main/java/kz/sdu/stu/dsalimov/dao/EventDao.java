package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Event;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EventDao {
    @Select(//language=PostgreSQL
            "SELECT  uuid, title, description, image, places_uuid as placeUuid FROM event")
    List<Event> findAll();

    @Select(//language=PostgreSQL
            "SELECT uuid, title, description, image, places_uuid as placesUuid FROM event WHERE uuid = #{uuid}")
    Event findByUuid(String uuid);

    @Insert(//language=PostgreSQL
            "INSERT INTO event (uuid, title, description, image, places_uuid) VALUES (#{uuid}, #{title}, #{description}, #{image}, #{placeUuid})")
    void insert(Event event);

    @Update(//language=PostgreSQL
            "UPDATE event SET title = #{title}, description = #{description}, image = #{image}, places_uuid = #{placeUuid} WHERE uuid = #{event_uuid}")
    void update(String event_uuid, Event event);

    @Delete(//language=PostgreSQL
            "DELETE FROM event WHERE uuid = #{uuid}")
    void deleteByUuid(String uuid);

    @Update(//language=PostgreSQL
            "UPDATE event SET title = #{title} WHERE uuid = #{uuid}")
    void updateTitle(@Param("uuid") String uuid, @Param("title") String title);

    @Update(//language=PostgreSQL
            "UPDATE event SET description = #{description} WHERE uuid = #{uuid}")
    void updateDescription(@Param("uuid") String uuid, @Param("description") String description);

    @Update(//language=PostgreSQL
            "UPDATE event SET image = #{image} WHERE uuid = #{uuid}")
    void updateImage(@Param("uuid") String uuid, @Param("image") String image);

    @Update(//language=PostgreSQL
            "UPDATE event SET places_uuid = #{placeUuid} WHERE uuid = #{uuid}")
    void updatePlaceUuid(@Param("uuid") String uuid, @Param("placeUuid") String placeUuid);

}
