package kz.sdu.stu.dsalimov.dto.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessDto {

    private int id;
    private String branchUuid;
    private Long userId;

    private Timestamp createdAt;

    private Timestamp updatedAt;

}