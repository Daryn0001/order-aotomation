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
    public void update(Category order) {

    }
}
