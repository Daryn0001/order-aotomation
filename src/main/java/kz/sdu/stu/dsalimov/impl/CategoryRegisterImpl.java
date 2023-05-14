package kz.sdu.stu.dsalimov.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import kz.sdu.stu.dsalimov.dao.CategoryDao;
import kz.sdu.stu.dsalimov.dto.db.Category;
import kz.sdu.stu.dsalimov.dto.filter.DishFilter;
import kz.sdu.stu.dsalimov.register.CategoryRegister;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CategoryRegisterImpl implements CategoryRegister {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategories() {
        return  this.categoryDao.getCategories();
    }

    @Override
    public Category findById(int id) {
        var dishCount = this.categoryDao.getDishCountFromCategory(id);
        var category = this.categoryDao.findById(id);
        category.setDishCount(dishCount);
        return category;
    }

    @Override
    public List<Category> getCategoriesByFilter(DishFilter filter) {
        return this.categoryDao.getCategoriesByFilter(filter);
    }

    @Override
    public void insert(Category category) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode picturesJsonArray = objectMapper.createArrayNode();
        picturesJsonArray.add(category.getImage());
        PGobject picturesJsonbObject = new PGobject();
        picturesJsonbObject.setType("json");

        try {
            picturesJsonbObject.setValue(picturesJsonArray.toString());
            this.categoryDao.insert(category, picturesJsonbObject);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        this.categoryDao.delete(id);
    }

    @Override
    public void update(int id, Category category) {
        this.categoryDao.update(id, category);
    }

    @Override
    public void updateParentCategoryId(int id, int parentCategoryId) {
        this.categoryDao.updateParentCategoryId(id, parentCategoryId);
    }

    @Override
    public void updateName(int id, String name) {
        this.categoryDao.updateName(id, name);
    }

    @Override
    public void updateDescription(int id, String description) {
        this.categoryDao.updateDescription(id, description);
    }

}
