package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.Orders;

import java.util.List;

public interface OrderRegister {

    List<Orders> getOrders();

    Orders findById(String uuid);

    String insert(Orders order);

    void delete(String uuid);

    void update(Orders order);

}
