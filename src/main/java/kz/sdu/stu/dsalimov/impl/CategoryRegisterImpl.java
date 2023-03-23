package kz.sdu.stu.dsalimov.impl;

import kz.sdu.stu.dsalimov.dao.CategoryDao;
import kz.sdu.stu.dsalimov.dto.db.Category;
import kz.sdu.stu.dsalimov.register.CategoryRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return this.categoryDao.findById(id);
    }

    @Override
    public void insert(Category category) {
        this.categoryDao.insert(category);
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
