package kz.sdu.stu.dsalimov.dto.db;

import kz.sdu.stu.dsalimov.util.Json;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(fluent = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Json
public class Booking {

    private String uuid;

    private String phone;

    private String name;

    private Date time;

    private String tableUuid;

}
