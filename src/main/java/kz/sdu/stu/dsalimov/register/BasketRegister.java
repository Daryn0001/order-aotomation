package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.BasketDto;

import java.util.List;

public interface BasketRegister {

    List<BasketDto> getBaskets();

    BasketDto findById(String uuid);

    void insert(BasketDto order);

    void delete(String uuid);

    void update(BasketDto basketDto);

    void updateAmount(String uuid, int amount);

    void updateDishUuid(String uuid, String dishUuid);

    void updateOrderUuid(String uuid, String orderUuid);

    void updatePrice(String uuid, int price);
}
