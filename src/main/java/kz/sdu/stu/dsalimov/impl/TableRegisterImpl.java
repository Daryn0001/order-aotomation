package kz.sdu.stu.dsalimov.impl;

import kz.sdu.stu.dsalimov.dao.TableDao;
import kz.sdu.stu.dsalimov.dto.db.TableDetails;
import kz.sdu.stu.dsalimov.register.TableRegister;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableRegisterImpl implements TableRegister {
    @Autowired
    private TableDao tableDao;


    @Override
    public List<TableDetails> getTables() {
        return this.tableDao.getTables();
    }

    @Override
    public TableDetails findById(String uuid) {
        return this.tableDao.findById(uuid);
    }

    @Override
    public String insert(TableDetails tableDetails) {
        return this.tableDao.insert(tableDetails);
    }

    @Override
    public void delete(String uuid) {
        this.tableDao.delete(uuid);
    }

    @Override
    public void update(TableDetails table) {
        System.out.println(" Update request table: " + table);
    }
}
