package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.to_client.SliderData;
import kz.sdu.stu.dsalimov.dto.to_client.MainPageHeader;

public interface MainPageRegister {

    MainPageHeader getHeader(String temporaryKey);

    SliderData getBody(String temporaryKey);

}
