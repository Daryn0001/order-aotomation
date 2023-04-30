package kz.sdu.stu.dsalimov.impl;

import kz.sdu.stu.dsalimov.dao.ElementDao;
import kz.sdu.stu.dsalimov.dto.db.Element;
import kz.sdu.stu.dsalimov.register.ElementRegister;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ElementRegisterImpl implements ElementRegister {
    @Autowired
    private ElementDao elementDao;

    @Override
    public List<Element> getElementsList() {
        return this.elementDao.findAll();
    }

    @Override
    public Element findByUuid(String uuid) {
        return this.elementDao.findByUuid(uuid);
    }

    @Override
    public void insert(Element element) {
        this.elementDao.insert(element);
    }

    @Override
    public void update(Element element) {
        this.elementDao.update(element);
    }

    @Override
    public void deleteByUuid(String uuid) {
        this.elementDao.deleteByUuid(uuid);
    }

    @Override
    public void updateDishUuid(String uuid, String dishUuid) {
        this.elementDao.updateDishUuid(uuid, dishUuid);
    }

    @Override
    public void updateEventUuid(String uuid, String eventUuid) {
        this.elementDao.updateEventUuid(uuid, eventUuid);
    }
}
