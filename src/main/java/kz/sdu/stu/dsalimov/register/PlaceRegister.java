package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.Place;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlaceRegister {
    List<Place> findAll();

    Place findByUuid(String uuid);

    void insert(Place place);

    void update(String uuid, Place place);

    void deleteByUuid(String uuid);

    void updateType( String uuid, String type);

    void updateSize( String uuid, String size);

    void updateName(String uuid, String name);
}
