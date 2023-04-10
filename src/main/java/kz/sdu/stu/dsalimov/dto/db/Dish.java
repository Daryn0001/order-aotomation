package kz.sdu.stu.dsalimov.dto.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dish {
    private String uuid;

    private String title;

    private String description;

    private String pictures;

    private String ingredients;

    private int amount;

    private String note;

    private String price;

    private boolean isActive;

    private int categoryId;

}
