package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.Dish;
import kz.sdu.stu.dsalimov.dto.filter.SearchFilter;
import kz.sdu.stu.dsalimov.dto.response.SuccessResponse;
import kz.sdu.stu.dsalimov.register.DishRegister;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app"})
public class DishesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final DishRegister dishRegister;

    @GetMapping("/dishes")
    public ResponseEntity<List<Dish>> getDishes() {
        List<Dish> dishes = this.dishRegister.getDishes();

        return new ResponseEntity<>(
                dishes,
                HttpStatus.OK
        );
    }

    @PostMapping("/get-dish/{uuid}")
    public ResponseEntity<Dish> findDishById(@PathVariable("uuid") String uuid) {
        Dish dish = this.dishRegister.findById(uuid);
        return new ResponseEntity<>(
                dish,
                HttpStatus.OK
        );
    }

    @PostMapping("/get-dish-by-event/{eventUuid}")
    public List<Dish> getDishByEvent(@PathVariable("eventUuid") String eventUuid) {
        LOGGER.info("1h3uK3D4kir :: eventUuid: " + eventUuid);

        return this.dishRegister.getDishesByEvent(eventUuid);
    }

    @PostMapping("/get-dish-by-filter")
    public ResponseEntity<List<Object>> getDishesByFilter(@RequestBody SearchFilter filter, @RequestParam String branchUuid) {
        LOGGER.info("ViZg29GO :: filter from cont: " + filter);
        var dishes = this.dishRegister.getDishesByFilter(filter, branchUuid);
        LOGGER.info("0wtq4TH2m48 :: dishes by filter: " + dishes);

        return new ResponseEntity<>( dishes, HttpStatus.OK);
    }

    @GetMapping("/get-dish-by-category/{categoryId}")
    public ResponseEntity<List<Dish>> getDishesByCategory(@PathVariable("categoryId") int categoryId) {
        LOGGER.info("VB4T2a1Pka :: category id: " + categoryId);
        var dishes = this.dishRegister.getDishesByCategory(categoryId);
        LOGGER.info("XFyu5v :: dishes by categoryId : " + dishes);

        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @PostMapping("/delete-dish/{uuid}")
    public void deleteDish(@PathVariable("uuid") String uuid) {
        this.dishRegister.delete(uuid);
    }

    @PostMapping("add/dish")
    public ResponseEntity<SuccessResponse> insertDish(@RequestBody Dish dish) {
        LOGGER.info("WcYSQ836 :: new dish: " + dish);

        if (!ObjectUtils.isEmpty(dish.getUuid())) {
            throw new RuntimeException(" Крч айлди должен быть пустым");
        }

        this.dishRegister.insert(dish);
        return new ResponseEntity<>(new SuccessResponse(dish, "new dish added successfully"), HttpStatus.OK);
    }

    @PostMapping("update-dish/{uuid}")
    public void updateDish(@RequestBody Dish dish, @PathVariable("uuid") String uuid) {
        LOGGER.info("lLMwDYctg1 :: uuid: " + uuid + "\nupdate dish: " + dish);

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

    @PostMapping("update-dish-note/{uuid}/{notes}")
    public void updateNote(@PathVariable("uuid") String uuid, @PathVariable("notes") String notes) {
        this.dishRegister.updateNotes(uuid, notes);
    }

    @PostMapping("update-dish-categoryId/{uuid}/{categoryId}")
    public void updateCategoryId(@PathVariable("uuid") String uuid, @PathVariable("categoryId") int categoryId) {
        this.dishRegister.updateCategoryId(uuid, categoryId);
    }

}
