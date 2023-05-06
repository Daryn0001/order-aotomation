package kz.sdu.stu.dsalimov.dto.to_client;

import kz.sdu.stu.dsalimov.dto.db.Category;
import kz.sdu.stu.dsalimov.dto.db.Dish;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class SearchResponse {
    private List<Category> categories;
    private List<Dish> dishes;

    public SearchResponse() {
        this.categories = new ArrayList<>();
        this.dishes = new ArrayList<>();
    }

    public List<Object> getResponse() {
        List<Object> response = new ArrayList<>(2);
        response.add(this.categories);
        response.add(this.dishes);
        return response;
    }


}
