package kz.sdu.stu.dsalimov.register;

import kz.sdu.stu.dsalimov.dto.db.Table;

import java.util.List;

public interface TableRegister {
    List<Table> getTables();

    Table findById(String uuid);

    String insert(Table table);

    String getBranchUuidByTemporaryKey(String temporaryKey);

    String getUuidByTemporaryKey(String temporaryKey);

    void delete(String uuid);

    void update(Table table);
}
