package kz.sdu.stu.dsalimov.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = false)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DishFilter {
    private int limit;
    private int offset;
    private String searchText;
    private String direction;
}
