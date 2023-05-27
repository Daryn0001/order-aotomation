package kz.sdu.stu.dsalimov.impl;

import kz.sdu.stu.dsalimov.controller.EventController;
import kz.sdu.stu.dsalimov.dao.BasketDao;
import kz.sdu.stu.dsalimov.dto.db.BasketDto;
import kz.sdu.stu.dsalimov.register.BasketRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BasketRegisterImpl implements BasketRegister {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private BasketDao basketDao;

    @Override
    public List<BasketDto> getBaskets() {
        return this.basketDao.getBaskets();
    }

    @Override
    public BasketDto findById(String uuid) {
        return this.basketDao.findById(uuid);
    }

    @Override
    public void insert(BasketDto basket) {
        UUID uuid = UUID.randomUUID();
        basket.setUuid(uuid.toString());

        LOGGER.info("6VW8CX06G :: insert new basket: " + basket);

        this.basketDao.insert(basket);
    }

    @Override
    public void delete(String uuid) {
        this.basketDao.delete(uuid);
    }

    @Override
    public void update(BasketDto basketDto) {

        this.basketDao.insert(basketDto);
    }

    @Override
    public void updateAmount(String uuid, int amount) {
        this.basketDao.updateAmount(uuid, amount);
    }

    @Override
    public void updateDishUuid(String uuid, String dishUuid) {
        this.basketDao.updateDishUuid(uuid, dishUuid);
    }

    @Override
    public void updateOrderUuid(String uuid, String orderUuid) {
        this.basketDao.updateOrderUuid(uuid, orderUuid);
    }

    @Override
    public void updatePrice(String uuid, int price) {
        this.basketDao.updatePrice(uuid, price);
    }
}
