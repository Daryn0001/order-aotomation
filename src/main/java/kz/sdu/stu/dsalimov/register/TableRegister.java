package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.Tables;

import java.util.List;

public interface TableRegister {
    List<Tables> getTables();

    Tables findById(String uuid);

    String insert(Tables tables);

    void delete(String uuid);

    void update(Tables table);
}
