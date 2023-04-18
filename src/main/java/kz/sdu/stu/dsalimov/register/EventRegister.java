package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.Event;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventRegister {
    List<Event> findAll();

    Event findByUuid(String uuid);

    void insert(Event event);

    void update(Event event);

    void deleteByUuid(String uuid);

    void updateTitle( String uuid,  String title);

    void updateDescription( String uuid,  String description);

    void updateImage (String uuid,  String image);

    void updatePlaceUuid( String uuid,  String placeUuid);

}
