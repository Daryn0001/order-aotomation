package kz.sdu.stu.dsalimov.dto.to_client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainPageHeader {
    private String tableNumber;
    private String address;
    private String companyName;

}
