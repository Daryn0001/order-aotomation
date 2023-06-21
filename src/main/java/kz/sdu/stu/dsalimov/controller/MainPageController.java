package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.to_client.SliderData;
import kz.sdu.stu.dsalimov.dto.to_client.MainPageHeader;
import kz.sdu.stu.dsalimov.register.MainPageRegister;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app", "http://77.243.80.82:3000"})
public class MainPageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final MainPageRegister mainPageRegister;

    @GetMapping("/get-slider-data")
    public ResponseEntity<SliderData> getSliderData(@RequestParam String temporaryKey) {
        var sliderData = this.mainPageRegister.getBody(temporaryKey);

        LOGGER.info("od2f6OqG3w :: sliderData: " + sliderData);

        return new ResponseEntity<>(sliderData,  HttpStatus.OK);
    }

    @GetMapping("/get-header-data")
    public MainPageHeader getHeader(@RequestParam String temporaryKey) {
        LOGGER.info("od2f6OqG3w :: getHeader tempKey: " + temporaryKey);

        return this.mainPageRegister.getHeader(temporaryKey);
    }

}
