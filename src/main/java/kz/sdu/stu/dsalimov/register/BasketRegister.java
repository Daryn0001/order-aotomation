package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.BasketDto;

import java.util.List;

public interface BasketRegister {

    List<BasketDto> getBaskets();

    BasketDto findById(String uuid);

    String insert(BasketDto order);

    void delete(String uuid);

    void update(BasketDto basketDto);
}
