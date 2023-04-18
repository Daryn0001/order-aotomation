package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.response.SuccessResponse;
import kz.sdu.stu.dsalimov.dto.to_client.MainPageBody;
import kz.sdu.stu.dsalimov.dto.to_client.MainPageHeader;
import kz.sdu.stu.dsalimov.register.MainPageRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app"})
public class MainPageController {
    private final MainPageRegister mainPageRegister;

    @GetMapping("get-body-data")
    public ResponseEntity<MainPageBody> getBody() {
        var body = this.mainPageRegister.getBody();

        System.out.println("od2f6OqG3w :: body: " + body);

        return new ResponseEntity<>(body,  HttpStatus.OK);
    }

    @GetMapping("get-header-data")
    public ResponseEntity<MainPageHeader> getHeader() {
        var header = this.mainPageRegister.getHeader();

        return new ResponseEntity<>(header, HttpStatus.OK);
    }

}
