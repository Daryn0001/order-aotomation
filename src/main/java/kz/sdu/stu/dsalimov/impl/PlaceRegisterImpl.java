package kz.sdu.stu.dsalimov.impl;

import kz.sdu.stu.dsalimov.dao.PlaceDao;
import kz.sdu.stu.dsalimov.dto.db.Place;
import kz.sdu.stu.dsalimov.register.PlaceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlaceRegisterImpl implements PlaceRegister {
    @Autowired
    private PlaceDao placeDao;

    @Override
    public List<Place> findAll() {
        return this.placeDao.findAll();
    }

    @Override
    public Place findByUuid(String uuid) {
        return this.placeDao.findByUuid(uuid);
    }

    @Override
    public void insert(Place place) {
        UUID uuid = UUID.randomUUID();
        place.setUuid(uuid.toString());
        this.placeDao.insert(place);
    }

    @Override
    public void update(Place place) {
        this.placeDao.update(place);
    }

    @Override
    public void deleteByUuid(String uuid) {
        this.placeDao.deleteByUuid(uuid);
    }

    @Override
    public void updateType(String uuid, String type) {
        this.placeDao.updateType(uuid, type);
    }

    @Override
    public void updateSize(String uuid, String size) {
        this.placeDao.updateSize(uuid, size);
    }
}
