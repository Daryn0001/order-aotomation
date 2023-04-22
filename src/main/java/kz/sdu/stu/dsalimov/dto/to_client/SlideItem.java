package kz.sdu.stu.dsalimov.dto.to_client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlideItem {
    private String uuid;
    private String title;
    private String image;
    private String placeUuid;
}
