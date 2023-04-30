package kz.sdu.stu.dsalimov.dto.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BasketDto {

    private String uuid;

    private int amount;

    private String dishUuid;

    private String orderUuid;

    private Timestamp createdAt;

    private Timestamp updatedAt;

}
