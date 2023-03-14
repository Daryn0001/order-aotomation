package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.Dish;
import kz.sdu.stu.dsalimov.dto.response.SuccessResponse;
import kz.sdu.stu.dsalimov.register.DishRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class DishesController {
    private final DishRegister dishRegister;

    @GetMapping("/dishes")
    public ResponseEntity<SuccessResponse> getDishes() {
        List<Dish> dishes = this.dishRegister.getDishes();

        return new ResponseEntity<>(
                new SuccessResponse(
                        dishes,
                        MessageFormat.format("{0}, Result found", dishes.size())),
                HttpStatus.OK
        );
    }

    @GetMapping("/getDish/{uuid}")
    public ResponseEntity<SuccessResponse> findDishById(@PathVariable("uuid") String uuid) {
        Dish dish = this.dishRegister.findById(uuid);
        return new ResponseEntity<>(
                new SuccessResponse(dish, ""),
                HttpStatus.OK
        );
    }
}
