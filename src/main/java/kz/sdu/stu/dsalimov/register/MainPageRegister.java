package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.to_client.MainPageBody;
import kz.sdu.stu.dsalimov.dto.to_client.MainPageHeader;

public interface MainPageRegister {

    MainPageHeader getHeader();

    MainPageBody getBody();

}
