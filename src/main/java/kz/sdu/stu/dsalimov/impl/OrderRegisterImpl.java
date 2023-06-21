package kz.sdu.stu.dsalimov.impl;

import kz.sdu.stu.dsalimov.controller.EventController;
import kz.sdu.stu.dsalimov.dao.OrderDao;
import kz.sdu.stu.dsalimov.dto.db.OrderDto;
import kz.sdu.stu.dsalimov.register.OrderRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderRegisterImpl implements OrderRegister {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<OrderDto> getOrders() {
        return this.orderDao.getTables();
    }

    @Override
    public OrderDto findById(String uuid) {
        return this.orderDao.findById(uuid);
    }

    @Override
    public void insert(OrderDto order) {
        UUID uuid = UUID.randomUUID();
        order.setUuid(uuid.toString());
        this.orderDao.insert(order);
    }

    @Override
    public void delete(String uuid) {
        this.orderDao.delete(uuid);
    }

    @Override
    public void update(OrderDto order) {
        LOGGER.info("PNaw7kY8j8UP ::  Update order not working yet");
    }
}
