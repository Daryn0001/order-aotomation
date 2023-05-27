package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.OrderDto;

import java.util.List;

public interface OrderRegister {

    List<OrderDto> getOrders();

    OrderDto findById(String uuid);

    void insert(OrderDto order);

    void delete(String uuid);

    void update(OrderDto order);

}
