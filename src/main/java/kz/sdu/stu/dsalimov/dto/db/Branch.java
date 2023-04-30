package kz.sdu.stu.dsalimov.dto.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    private String uuid;
    private String name;
    private String address;
    private Long adminUuid;
    private String companyId;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}