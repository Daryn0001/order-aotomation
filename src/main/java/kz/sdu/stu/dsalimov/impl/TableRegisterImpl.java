package kz.sdu.stu.dsalimov.impl;

import kz.sdu.stu.dsalimov.dao.TableDao;
import kz.sdu.stu.dsalimov.dto.db.Table;
import kz.sdu.stu.dsalimov.register.TableRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TableRegisterImpl implements TableRegister {
    @Autowired
    private TableDao tableDao;

    @Override
    public List<Table> getTables() {
        return this.tableDao.findAll();
    }

    @Override
    public Table findById(String uuid) {
        return this.tableDao.findById(uuid);
    }

    @Override
    public String insert(Table table) {
        UUID uuid = UUID.randomUUID();
        table.setUuid(uuid.toString());
        return this.tableDao.insert(table);
    }

    @Override
    public void delete(String uuid) {
        this.tableDao.delete(uuid);
    }

    @Override
    public void update(Table table) {
        System.out.println(" Update request table: " + table);
    }
}
