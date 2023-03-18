package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.Dish;

import java.util.List;

public interface DishRegister {
    List<Dish> getDishes();

    Dish findById(String uuid);

    void insert(Dish dish);

    void delete(String uuid);

    void update(Dish dish);
}
