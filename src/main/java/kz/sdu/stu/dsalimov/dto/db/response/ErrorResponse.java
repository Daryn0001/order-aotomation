package kz.sdu.stu.dsalimov.dto.db.response;

import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ErrorResponse {

    /**
     * error code
     */
    private String code;
    /**
     * short error message
     */
    private String message;

    /**
     * error cause timestamp
     */
    private Instant timestamp;
}