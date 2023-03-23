package kz.sdu.stu.dsalimov.impl;

import kz.sdu.stu.dsalimov.dao.DishDao;
import kz.sdu.stu.dsalimov.dto.db.Dish;
import kz.sdu.stu.dsalimov.register.DishRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        UUID uuid = UUID.randomUUID();
        dish.setUuid(uuid.toString());
         this.dishDao.insert(dish);
    }

    @Override
    public void delete(String uuid) {
        this.dishDao.delete(uuid);
    }

    @Override
    public void update(String uuid, Dish dish) {
        this.dishDao.update(uuid, dish);
    }

    @Override
    public void updateTitle(String uuid, String title) {
        this.dishDao.updateTitle(uuid, title);
    }

    @Override
    public void updateDescription(String uuid, String description) {
        this.dishDao.updateDescription(uuid, description);
    }

    @Override
    public void updatePicture(String uuid, String pictures) {
        this.dishDao.updatePicture(uuid, pictures);
    }

    @Override
    public void updateIngredients(String uuid, String ingredients) {
        this.dishDao.updateIngredients(uuid, ingredients);
    }

    @Override
    public void updateAmount(String uuid, int amount) {
        this.dishDao.updateAmount(uuid, amount);
    }

    @Override
    public void updateNotes(String uuid, String notes) {
        this.dishDao.updateNote(uuid, notes);
    }

    @Override
    public void updateBody(String uuid, String body) {
        this.dishDao.updateBody(uuid, body);
    }

    @Override
    public void updateCategoryId(String uuid, int category_id) {
        this.dishDao.updateCategoryId(uuid, category_id);
    }
}
