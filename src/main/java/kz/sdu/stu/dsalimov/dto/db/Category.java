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
public class Category {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "parent_category_id", nullable = false, unique = true)
    private int parentCategoryId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;
}
