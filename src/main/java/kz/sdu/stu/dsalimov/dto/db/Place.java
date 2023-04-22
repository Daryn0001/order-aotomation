package kz.sdu.stu.dsalimov.dto.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    private String uuid;

    private String name;

    private String type;

    private String size;
}
