package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.Place;
import kz.sdu.stu.dsalimov.dto.response.SuccessResponse;
import kz.sdu.stu.dsalimov.register.PlaceRegister;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app", "http://77.243.80.82:3000"})
@RequestMapping(value = "/api")
public class PlaceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceController.class);
    private final PlaceRegister placeRegister;

    @GetMapping("/places")
    public ResponseEntity<List<Place>> getPlaceList() {
        var placeList = this.placeRegister.findAll();
        LOGGER.info("get all places request");
        return new ResponseEntity<>(placeList, HttpStatus.OK);
    }

    @GetMapping("/get-place-by-id/{uuid}")
    public ResponseEntity<Place> getPlaceById(@PathVariable("uuid") String uuid) {
        var place = this.placeRegister.findByUuid(uuid);
        return new ResponseEntity<>(place, HttpStatus.OK);
    }

    @PostMapping("/add/place")
    public ResponseEntity<SuccessResponse> insertPLaces(@RequestBody Place place) {
        LOGGER.info(" Place to Save: " + place);
        if (place.getUuid() != null) {
            throw new RuntimeException("Крч айди должен быть пустым");
        }
        this.placeRegister.insert(place);
        return new ResponseEntity<>(new SuccessResponse(place, "new place added successfully"), HttpStatus.OK);
    }

    @PostMapping("/delete-place-by-id/{uuid}")
    public void deletePlaceById(@PathVariable("uuid") String uuid) {
        this.placeRegister.deleteByUuid(uuid);
    }

    @PostMapping("/update-place/{uuid}")
    public void update(@PathVariable("uuid") String uuid, @RequestBody Place place) {
        this.placeRegister.update(uuid, place);
    }

    @PostMapping("/update-place-name/{uuid}")
    public void updateName(@PathVariable("uuid") String uuid, @RequestBody String name) {
        this.placeRegister.updateName(uuid, name);
    }

    @PostMapping("/update-place-type/{uuid}")
    public void updateType(@PathVariable("uuid") String uuid, @RequestBody String type) {
        this.placeRegister.updateType(uuid, type);
    }

    @PostMapping("/update-place-size/{uuid}")
    public void updateSize(@PathVariable("uuid") String uuid, @RequestBody String size) {
        this.placeRegister.updateSize(uuid, size);
    }
}
