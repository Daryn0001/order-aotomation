package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.Dish;
import kz.sdu.stu.dsalimov.dto.response.SuccessResponse;
import kz.sdu.stu.dsalimov.register.DishRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app"})
public class DishesController {
    private final DishRegister dishRegister;

    @GetMapping("/dishes")
    public ResponseEntity< List<Dish>> getDishes() {
        List<Dish> dishes = this.dishRegister.getDishes();

        return new ResponseEntity<>(
                        dishes,
                HttpStatus.OK
        );
    }

    @GetMapping("/getDish/{uuid}")
    public ResponseEntity<Dish> findDishById(@PathVariable("uuid") String uuid) {
        Dish dish = this.dishRegister.findById(uuid);
        return new ResponseEntity<>(
               dish,
                HttpStatus.OK
        );
    }

    @PostMapping("/deleteDish/{uuid}")
    public void deleteDish(@PathVariable("uuid") String uuid) {
        this.dishRegister.delete(uuid);
    }

    @PostMapping("add/dish")
    public ResponseEntity<SuccessResponse> insertDish(@RequestBody Dish dish) {
        System.out.println(" new dish: " + dish);

        if (!ObjectUtils.isEmpty(dish.getUuid())) {
            throw new RuntimeException(" Крч айлди должен быть пустым");
        }

        this.dishRegister.insert(dish);
        return new ResponseEntity<>(new SuccessResponse(dish, "new dish added successfully"), HttpStatus.OK);
    }
}
