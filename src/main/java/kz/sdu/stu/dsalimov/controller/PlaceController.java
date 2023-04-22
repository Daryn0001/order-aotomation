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
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app"})
@RequestMapping(value = "/api")
public class PlaceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseControllerAdvice.class);
    private final PlaceRegister placeRegister;

    @GetMapping("/places")
    public ResponseEntity<List<Place>> getPlaceList() {
        var placeList = this.placeRegister.findAll();

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
        if( place.getUuid() != null ) {
            throw new RuntimeException("Крч айди должен быть пустым");
        }
        this.placeRegister.insert(place);
        return new ResponseEntity<>(new SuccessResponse(place, "new place added successfully"), HttpStatus.OK);

    }


    @PostMapping("/delete-place-by-id/{uuid}")
    public void deletePlaceById(@PathVariable("uuid") String uuid) {
        this.placeRegister.deleteByUuid(uuid);
    }
}
