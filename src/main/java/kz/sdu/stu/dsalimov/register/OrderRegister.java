package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.OrderDetails;

import java.util.List;

public interface OrderRegister {

    List<OrderDetails> getOrders();

    OrderDetails findById(String uuid);

    String insert(OrderDetails order);

    void delete(String uuid);

    void update(OrderDetails order);

}
