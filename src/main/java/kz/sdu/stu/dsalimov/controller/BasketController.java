package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.BasketDto;
import kz.sdu.stu.dsalimov.register.BasketRegister;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app"})
public class BasketController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final BasketRegister basketRegister;

    @GetMapping("/get-basket-list")
    public List<BasketDto> getBaskets() {
        return this.basketRegister.getBaskets();
    }

    @GetMapping("/get-basket-by-id/{uuid}")
    public BasketDto getBasketById(@PathVariable("uuid") String uuid) {
        return this.basketRegister.findById(uuid);
    }

    @PostMapping("/add-basket")
    public void insertBasket(@RequestBody BasketDto basket) {
        this.basketRegister.insert(basket);
    }

    @PostMapping("/delete-basket-by-id/{uuid}")
    public void deleteBasket(@PathVariable("uuid") String uuid) {
        this.basketRegister.delete(uuid);
    }

    @PostMapping("/update-basket-by-id")
    public void updateBasket(@RequestBody BasketDto basket) {
        this.basketRegister.update(basket);
    }
}
