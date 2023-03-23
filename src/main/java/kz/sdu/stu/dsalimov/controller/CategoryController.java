package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.Category;
import kz.sdu.stu.dsalimov.dto.response.SuccessResponse;
import kz.sdu.stu.dsalimov.register.CategoryRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app"})
@RequestMapping(value = "/api")
public class CategoryController {
    private final CategoryRegister categoryRegister;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = this.categoryRegister.getCategories();
        return new ResponseEntity<>(
                categories,
                HttpStatus.OK
        );
    }

    @GetMapping("/get-category/{id}")
    public ResponseEntity<Category> findDishById(@PathVariable("id") int id) {
        Category category = this.categoryRegister.findById(id);
        return new ResponseEntity<>(
                category,
                HttpStatus.OK
        );
    }

    @PostMapping("/add/category")
    public ResponseEntity<SuccessResponse> insertCategory(@RequestBody Category category) {
        System.out.println(" new category: " + category);
        if ((category.getId() != 0)) {
            throw new RuntimeException("Крч айди должен быть пустым");
        }

        this.categoryRegister.insert(category);
        return new ResponseEntity<>(new SuccessResponse(category, "new category added successfully"), HttpStatus.OK);
    }

    @PostMapping("/delete-category/{id}")
    public void deleteCategory(@PathVariable int id) {
        this.categoryRegister.delete(id);
    }

    @PostMapping("update-category/{id}")
    public void update(@PathVariable int id, @RequestBody Category category) {
        this.categoryRegister.update(id, category);
    }

    @PostMapping("update-category-parentCategoryId/{id}/{parentCategoryId}")
    public void updateParentCategoryId(@PathVariable("id") int id, @PathVariable("parentCategoryId") int parentCategoryId) {
        this.categoryRegister.updateParentCategoryId(id, parentCategoryId);
    }

    @PostMapping("update-category-name/{id}/{name}")
    public void updateName(@PathVariable("id") int id, @PathVariable("name") String name) {
        this.categoryRegister.updateName(id, name);
    }

    @PostMapping("update-category-description/{id}/{description}")
    public void updateDescription(@PathVariable("id") int id, @PathVariable("description") String description) {
        this.categoryRegister.updateDescription(id, description);
    }
}
