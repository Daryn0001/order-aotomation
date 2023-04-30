package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.Element;

import java.util.List;

public interface ElementRegister {
    List<Element> getElementsList();

    Element findByUuid(String uuid);

    void insert(Element element);

    void update(Element element);

    void deleteByUuid(String uuid);

    void updateDishUuid(String uuid, String dishUuid);

    void updateEventUuid(String uuid, String eventUuid);

}
