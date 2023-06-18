package kz.sdu.stu.dsalimov.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import kz.sdu.stu.dsalimov.controller.EventController;
import kz.sdu.stu.dsalimov.dao.CategoryDao;
import kz.sdu.stu.dsalimov.dao.DishDao;
import kz.sdu.stu.dsalimov.dto.db.Dish;
import kz.sdu.stu.dsalimov.dto.filter.SearchFilter;
import kz.sdu.stu.dsalimov.dto.to_client.SearchResponse;
import kz.sdu.stu.dsalimov.register.DishRegister;
import org.postgresql.util.PGobject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class DishRegisterImpl implements DishRegister {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private DishDao dishDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Dish> getDishes() {
        return this.dishDao.getDishes();
    }

    @Override
    public Dish findById(String uuid) {
        return this.dishDao.findById(uuid);
    }

    @Override
    public List<Dish> getDishesByEvent(String eventUuid) {
        var dishes = this.dishDao.getDishesByEvent(eventUuid);
        LOGGER.info("zTzOxYcRMJf :: dishes: " + dishes);
        return dishes;
    }

    @Override
    public List<Object> getDishesByFilter(SearchFilter filter,  String branchUuid) {
        var searchResponse = new SearchResponse();
        var categories = this.categoryDao.getCategoriesByFilter(filter, branchUuid);
        var dishes = dishDao.getDishesByFilter(filter);

        searchResponse.setDishes(dishes);
        searchResponse.setCategories(categories);
        return searchResponse.getResponse();
    }

    @Override
    public List<Dish> getDishesByCategory(int categoryId) {
        return this.dishDao.getDishesByCategory(categoryId);
    }

    @Override
    public void insert(Dish dish) {
        UUID uuid = UUID.randomUUID();
        dish.setUuid(uuid.toString());

        LOGGER.info("AB2d8gNoulOl :: new dish: " + dish);

        var ingredients = dish.getIngredients().split(",");

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode picturesJsonArray = objectMapper.createArrayNode();
        ArrayNode ingredientsJsonArray = objectMapper.createArrayNode();
        picturesJsonArray.add(dish.getPictures());

        for(String ingredient : ingredients) {
            ingredientsJsonArray.add(ingredient.trim());
        }

        LOGGER.info("1zOPV4vlW :: pictures json: " + picturesJsonArray);
        LOGGER.info("1zOPV4vlW :: ingredients json: " + ingredientsJsonArray);

        PGobject picturesJsonbObject = new PGobject();
        PGobject ingredientsJsonbObject = new PGobject();
        picturesJsonbObject.setType("json");
        ingredientsJsonbObject.setType("json");

        try {
            picturesJsonbObject.setValue(picturesJsonArray.toString());
            ingredientsJsonbObject.setValue(ingredientsJsonArray.toString());

            this.dishDao.insert(dish, ingredientsJsonbObject, picturesJsonbObject);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public void updateCategoryId(String uuid, int category_id) {
        this.dishDao.updateCategoryId(uuid, category_id);
    }
}
