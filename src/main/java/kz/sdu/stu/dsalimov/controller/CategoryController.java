package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.Category;
import kz.sdu.stu.dsalimov.dto.db.Dish;
import kz.sdu.stu.dsalimov.dto.response.SuccessResponse;
import kz.sdu.stu.dsalimov.register.CategoryRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class CategoryController {
    private final CategoryRegister categoryRegister;

    @GetMapping("/getCategories")
    public ResponseEntity<SuccessResponse> getCategories() {
        List<Category> categories = this.categoryRegister.getCategories();
        return new ResponseEntity<>(
                new SuccessResponse(
                        categories,
                        MessageFormat.format("{0}, Result found", categories.size())),
                HttpStatus.OK
        );
    }

    @GetMapping("/getCategory/{id}")
    public ResponseEntity<SuccessResponse> findDishById(@PathVariable("id") int id) {
        Category category = this.categoryRegister.findById(id);
        return new ResponseEntity<>(
                new SuccessResponse(category, ""),
                HttpStatus.OK
        );
    }
}
