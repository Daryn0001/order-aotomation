package kz.sdu.stu.dsalimov.dto.to_client;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class SliderData {
    private Map<String, Slide> stringSlideMap;

    public SliderData() {
        stringSlideMap = new HashMap<>();
    }

    public void addSlides(String slideName, Slide slide) {
        this.stringSlideMap.put(slideName, slide);
    }
}
