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
    public ResponseEntity<SuccessResponse> getDishes() {
        List<Dish> dishes = this.dishRegister.getDishes();

        return new ResponseEntity<>(
                new SuccessResponse(
                        dishes,
                        MessageFormat.format("{0}, Result found", dishes.size())),
                HttpStatus.OK
        );
    }

    @GetMapping("/get-dish/{uuid}")
    public ResponseEntity<SuccessResponse> findDishById(@PathVariable("uuid") String uuid) {
        Dish dish = this.dishRegister.findById(uuid);
        return new ResponseEntity<>(
                new SuccessResponse(dish, ""),
                HttpStatus.OK
        );
    }

    @PostMapping("/delete-dish/{uuid}")
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

    @PostMapping("update-dish/{uuid}")
    public void updateDish(@RequestBody Dish dish, @PathVariable("uuid") String uuid) {
        System.out.println("uuid: " + uuid + "\nupdate dish: " + dish );

        this.dishRegister.update(uuid, dish);
    }

    @PostMapping("update-dish-title/{uuid}/{title}")
    public void updateTitle(@PathVariable("uuid") String uuid, @PathVariable("title") String title) {
        this.dishRegister.updateTitle(uuid, title);
    }

    @PostMapping("update-dish-description/{uuid}/{description}")
    public void updateDescription(@PathVariable("uuid") String uuid, @PathVariable("description") String description) {
        this.dishRegister.updateDescription(uuid, description);
    }

    @PostMapping("update-dish-picture/{uuid}/{picture}")
    public void updatePicture(@PathVariable("uuid") String uuid, @PathVariable("picture") String pictures) {
        this.dishRegister.updatePicture(uuid, pictures);
    }

    @PostMapping("update-dish-ingredients/{uuid}/{ingredients}")
    public void updateIngredients(@PathVariable("uuid") String uuid, @PathVariable("ingredients") String ingredients) {
        this.dishRegister.updateIngredients(uuid, ingredients);
    }

    @PostMapping("update-dish-amount/{uuid}/{amount}")
    public void updateAmount(@PathVariable("uuid") String uuid, @PathVariable("amount") int amount) {
        this.dishRegister.updateAmount(uuid, amount);
    }

    @PostMapping("update-dish-note/{uuid}/{note}")
    public void updateNote(@PathVariable("uuid") String uuid, @PathVariable("note") String note) {
        this.dishRegister.updateNotes(uuid, note);
    }

    @PostMapping("update-dish-body/{uuid}/{body}")
    public void updateBody(@PathVariable("uuid") String uuid, @PathVariable("body") String body) {
        this.dishRegister.updateBody(uuid, body);
    }

    @PostMapping("update-dish-categoryId/{uuid}/{categoryId}")
    public void updateCategoryId(@PathVariable("uuid") String uuid, @PathVariable("categoryId") int categoryId) {
        this.dishRegister.updateCategoryId(uuid, categoryId);
    }

}
