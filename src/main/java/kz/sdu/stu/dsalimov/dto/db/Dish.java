package kz.sdu.stu.dsalimov.dto.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import kz.sdu.stu.dsalimov.util.Json;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Json
public class Dish {

    @Id
    @Column(name = "uuid", nullable = false, unique = true)
    private String uuid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "pictures", nullable = false)
    private String pictures;

    @Column(name = "ingredients", nullable = false)
    private String ingredients;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "notes", nullable = false)
    private String notes;

    @Column(name = "category_id", nullable = false, unique = true)
    private int categoryId;

}
