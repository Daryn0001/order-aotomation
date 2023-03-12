package kz.sdu.stu.dsalimov.dto.db.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SuccessResponse {
    private Object data;
    private String message;
}