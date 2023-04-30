package kz.sdu.stu.dsalimov.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import kz.sdu.stu.dsalimov.dao.EventDao;
import kz.sdu.stu.dsalimov.dto.db.Event;
import kz.sdu.stu.dsalimov.register.EventRegister;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class EventRegisterImpl implements EventRegister {
    @Autowired
    private EventDao eventDao;

    @Override
    public List<Event> findAll() {
        return this.eventDao.findAll();
    }

    @Override
    public Event findByUuid(String uuid) {
        return this.eventDao.findByUuid(uuid);
    }

    @Override
    public void insert(Event event) {
        UUID uuid = UUID.randomUUID();
        event.setUuid(uuid.toString());


        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode imageJsonArray = objectMapper.createArrayNode();
        imageJsonArray.add(event.getImage());

        System.out.println("TXGRsJ0t :: json: " + imageJsonArray);


        PGobject jsonbObject = new PGobject();
        jsonbObject.setType("jsonb");
        try {
            jsonbObject.setValue(imageJsonArray.toString());

            System.out.println("NSbMEtIkb :: jsonb: " + jsonbObject);
           var ll =  this.eventDao.insert(event, jsonbObject);
            System.out.println("Ee29MiGUKiU0 :: LL: " + ll);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(String uuid, Event event) {
        this.eventDao.update(uuid, event);
    }

    @Override
    public void deleteByUuid(String uuid) {
        this.eventDao.deleteByUuid(uuid);
    }

    @Override
    public void updateTitle(String uuid, String title) {
        this.eventDao.updateTitle(uuid, title);
    }

    @Override
    public void updateDescription(String uuid, String description) {
        this.eventDao.updateDescription(uuid, description);

    }

    @Override
    public void updateImage(String uuid, String image) {
        this.eventDao.updateImage(uuid, image);

    }

    @Override
    public void updatePlaceUuid(String uuid, String placeUuid) {
        this.eventDao.updatePlaceUuid(uuid, placeUuid);

    }
}
