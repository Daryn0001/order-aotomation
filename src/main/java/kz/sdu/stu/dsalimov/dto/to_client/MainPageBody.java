package kz.sdu.stu.dsalimov.dto.to_client;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class MainPageBody {
    private Map<String, Slide> data;

    public MainPageBody() {
        data = new HashMap<>();
    }

    public void addSlides(String slideName, Slide slide) {
        this.data.put(slideName, slide);
    }
}
