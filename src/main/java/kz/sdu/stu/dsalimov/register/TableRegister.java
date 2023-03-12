package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.TableDetails;

import java.util.List;

public interface TableRegister {
    List<TableDetails> getTables();

    TableDetails findById(String uuid);

    String insert(TableDetails tableDetails);

    void delete(String uuid);

    void update(TableDetails table);
}
