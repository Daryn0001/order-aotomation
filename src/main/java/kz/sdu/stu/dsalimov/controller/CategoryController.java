package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.Category;
import kz.sdu.stu.dsalimov.dto.response.SuccessResponse;
import kz.sdu.stu.dsalimov.register.CategoryRegister;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app", "http://77.243.80.82:3000"})
@RequestMapping(value = "/api")
public class CategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final CategoryRegister categoryRegister;

    @PostMapping("/categories")
    public ResponseEntity<List<Category>> getCategories(@RequestParam("branchUuid") String branchUuid) {
        List<Category> categories = this.categoryRegister.getCategories(branchUuid);
        return new ResponseEntity<>(
                categories,
                HttpStatus.OK
        );
    }

    @GetMapping("/get-category-by-id/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable("id") int id) {
        Category category = this.categoryRegister.findById(id);
        LOGGER.info("found category by id: " + id + " \ncategory: " + category);
        return new ResponseEntity<>(
                category,
                HttpStatus.OK
        );
    }

    @PostMapping("/add/category")
    public ResponseEntity<SuccessResponse> insertCategory(@RequestBody Category category) {
        LOGGER.info(" new category: " + category);
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
