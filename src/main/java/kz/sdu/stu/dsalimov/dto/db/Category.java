package kz.sdu.stu.dsalimov.dto.db;

import kz.sdu.stu.dsalimov.util.Json;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Json
public class Category {

    private int id;

    private int parentCategoryId;

    private String name;

    private String description;
}
