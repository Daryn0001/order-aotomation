package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.Category;

import java.util.List;

public interface CategoryRegister {
    List<Category> getCategories();

    Category findById(int uuid);

    void insert(Category order);

    void delete(int uuid);

    void update(Category order);
}
