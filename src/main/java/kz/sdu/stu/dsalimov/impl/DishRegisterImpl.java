package kz.sdu.stu.dsalimov.impl;

import kz.sdu.stu.dsalimov.dao.DishDao;
import kz.sdu.stu.dsalimov.dto.db.Dish;
import kz.sdu.stu.dsalimov.register.DishRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishRegisterImpl implements DishRegister {
    @Autowired
    private DishDao dishDao;

    @Override
    public List<Dish> getDishes() {
        return this.dishDao.getDishes();
    }

    @Override
    public Dish findById(String uuid) {
        return this.dishDao.findById(uuid);
    }

    @Override
    public void insert(Dish dish) {
         this.dishDao.insert(dish);
    }

    @Override
    public void delete(String uuid) {
        this.dishDao.delete(uuid);
    }

    @Override
    public void update(Dish order) {

    }
}
