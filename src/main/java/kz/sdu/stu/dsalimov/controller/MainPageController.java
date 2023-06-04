package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.to_client.MainPageBody;
import kz.sdu.stu.dsalimov.dto.to_client.MainPageHeader;
import kz.sdu.stu.dsalimov.register.MainPageRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app"})
public class MainPageController {
    private final MainPageRegister mainPageRegister;

    @GetMapping("/get-slider-data/{temporaryKey}")
    public ResponseEntity<MainPageBody> getBody(@PathVariable("temporaryKey") String temporaryKey) {
        var body = this.mainPageRegister.getBody(temporaryKey);

        System.out.println("od2f6OqG3w :: body: " + body);

        return new ResponseEntity<>(body,  HttpStatus.OK);
    }

    @GetMapping("/get-header-data/{temporaryKey}")
    public ResponseEntity<MainPageHeader> getHeader(@PathVariable("temporaryKey") String temporaryKey) {
        var header = this.mainPageRegister.getHeader(temporaryKey);

        return new ResponseEntity<>(header, HttpStatus.OK);
    }

}
