package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.Category;
import kz.sdu.stu.dsalimov.dto.filter.SearchFilter;

import java.util.List;

public interface CategoryRegister {
    List<Category> getCategories(String branchUuid);

    Category findById(int uuid);

    List<Category> getCategoriesByFilter(SearchFilter filter,  String branchUuid);

    void insert(Category category);

    void delete(int id);

    void update(int id, Category category);

    void updateParentCategoryId(int id, int parentCategoryId);

    void updateName(int id, String name);

    void updateDescription(int id, String description);

}
