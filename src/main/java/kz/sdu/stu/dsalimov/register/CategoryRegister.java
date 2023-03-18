package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.Category;

import java.util.List;

public interface CategoryRegister {
    List<Category> getCategories();

    Category findById(int uuid);

    void insert(Category category);

    void delete(int id);

    void update(Category category);
}
