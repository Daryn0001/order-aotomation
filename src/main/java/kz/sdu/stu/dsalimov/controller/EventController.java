package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.Event;
import kz.sdu.stu.dsalimov.dto.response.SuccessResponse;
import kz.sdu.stu.dsalimov.register.EventRegister;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app"})
@RequestMapping(value = "/api")
public class EventController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final EventRegister eventRegister;

    @GetMapping("/get-event-list")
    public ResponseEntity<List<Event>> getEvents() {
        List<Event> events =  this.eventRegister.findAll();
        return new ResponseEntity<>(
                events,
                HttpStatus.OK
        );
    }

    @GetMapping("/get-event-by-id/{uuid}")
    public ResponseEntity<Event> findById(@PathVariable("uuid") String uuid) {
        var event = this.eventRegister.findByUuid(uuid);
        return new ResponseEntity<>(
                event,
                HttpStatus.OK
        );
    }

    @PostMapping("/add/event")
    public ResponseEntity<SuccessResponse> insertEvent(@RequestBody Event event) {
        System.out.println(" new Event to Save: " + event);
        LOGGER.info(" Event to Save: " + event);
        if( event.getUuid() != null ) {
            throw new RuntimeException("Крч айди должен быть пустым");
        }
        this.eventRegister.insert(event);
        return new ResponseEntity<>(new SuccessResponse(event, "new event added successfully"), HttpStatus.OK);
    }

    @PostMapping("/delete-event-by-id/{uuid}")
    public void deleteEventById(@PathVariable("uuid") String uuid) {
        this.eventRegister.deleteByUuid(uuid);
    }

    @PostMapping("/update-event/{uuid}")
    public void update(@PathVariable String uuid, @RequestBody Event event) {
        LOGGER.info("fdj7BeT4u48 :: uuid: " + uuid);
        LOGGER.info("vLT2hz6ajglu :: event: " + event);
        this.eventRegister.update(uuid, event);
    }

    @PostMapping("/update-event-description/{uuid}")
    public void updateDescription(@RequestBody String description, @PathVariable("uuid") String uuid) {
        this.eventRegister.updateDescription(uuid, description);
    }

    @PostMapping("/update-event-title/{uuid}")
    public void updateTitle(@PathVariable("uuid") String uuid, @RequestBody String title) {
        this.eventRegister.updateTitle(uuid, title);
    }

    @PostMapping("/update-event-image/{uuid}")
    public void updateImage(@PathVariable("uuid") String uuid, @RequestBody String img) {
        this.eventRegister.updateImage(uuid, img);
    }


}
