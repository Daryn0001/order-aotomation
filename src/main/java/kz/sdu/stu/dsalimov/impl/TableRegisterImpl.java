package kz.sdu.stu.dsalimov.impl;

import kz.sdu.stu.dsalimov.dao.TableDao;
import kz.sdu.stu.dsalimov.dto.db.Tables;
import kz.sdu.stu.dsalimov.register.TableRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableRegisterImpl implements TableRegister {
    @Autowired
    private TableDao tableDao;

    @Override
    public List<Tables> getTables() {
        return this.tableDao.findAll();
    }

    @Override
    public Tables findById(String uuid) {
        return this.tableDao.findById(uuid);
    }

    @Override
    public String insert(Tables tables) {
        return this.tableDao.insert(tables);
    }

    @Override
    public void delete(String uuid) {
        this.tableDao.delete(uuid);
    }

    @Override
    public void update(Tables table) {
        System.out.println(" Update request table: " + table);
    }
}
