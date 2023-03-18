package kz.sdu.stu.dsalimov.dto.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetails {

    private String uuid;

    private String phone;

    private String name;

    private String bookingUuid;

    private String tableUuid;

    private int price;

}
