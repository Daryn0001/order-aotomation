package kz.sdu.stu.dsalimov.dto.to_client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slide {
    private String name;
    private String type;
    private String size;
    private List<SlideItem> list;
}
