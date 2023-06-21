package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.OrderDto;
import kz.sdu.stu.dsalimov.register.OrderRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app"})
public class OrderController {
    private final OrderRegister orderRegister;

    @GetMapping("/get-order-list")
    public List<OrderDto> getOrders() {
        return this.orderRegister.getOrders();
    }

    @GetMapping("/get-order-by-id/{uuid}")
    public OrderDto getOrderById(@PathVariable("uuid") String uuid) {
        return this.orderRegister.findById(uuid);
    }

    @PostMapping("/add-order")
    public String insertOrder(@RequestBody OrderDto order) {
        this.orderRegister.insert(order);
        return order.getUuid();
    }

    @PostMapping("/delete-order-by-id/{uuid}")
    public void deleteOrder(@PathVariable("uuid") String uuid) {
        this.orderRegister.delete(uuid);
    }
}
