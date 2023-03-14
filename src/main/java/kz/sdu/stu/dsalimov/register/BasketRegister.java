package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.Basket;

import java.util.List;

public interface BasketRegister {

    List<Basket> getBaskets();

    Basket findById(String uuid);

    String insert(Basket order);

    void delete(String uuid);

    void update(Basket basket);
}
