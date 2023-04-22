package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.Event;

import java.util.List;

public interface EventRegister {
    List<Event> findAll();

    Event findByUuid(String uuid);

    void insert(Event event);

    void update(String uuid, Event event);

    void deleteByUuid(String uuid);

    void updateTitle( String uuid,  String title);

    void updateDescription( String uuid,  String description);

    void updateImage (String uuid,  String image);

    void updatePlaceUuid( String uuid,  String placeUuid);

}
