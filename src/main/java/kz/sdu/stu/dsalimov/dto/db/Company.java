package kz.sdu.stu.dsalimov.dto.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String uuid;
    private String name;
    private String description;
    private String address;
    private String phone;
    private Long ownerId;
}
