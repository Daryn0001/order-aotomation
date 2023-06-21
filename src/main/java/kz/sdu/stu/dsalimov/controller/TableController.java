package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.Table;
import kz.sdu.stu.dsalimov.register.TableRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app", "http://77.243.80.82:3000"})
@RequestMapping(value = "/api")
public class TableController {
    private final TableRegister tableRegister;

    @GetMapping("/tables")
    public ResponseEntity<List<Table>> getTables() {
        List<Table> tables = this.tableRegister.getTables();
        System.out.println(" get mappings tb: " + tables);
        return new ResponseEntity<>(
                tables,
                HttpStatus.OK
        );
    }

    @GetMapping("/getTable/{uuid}")
    public @ResponseBody ResponseEntity<Table> getTableById(@PathVariable("uuid") String uuid) {
        System.out.println(" found by id: " + this.tableRegister.findById(uuid));
        return new ResponseEntity<>(
                this.tableRegister.findById(uuid),
                HttpStatus.OK
        );
    }

    @GetMapping("/table/{uuid}")
    public ResponseEntity<Table> getTable(@PathVariable("uuid") String uuid) {
        return new ResponseEntity<>(this.tableRegister.findById(uuid), HttpStatus.OK);
    }

    @PostMapping("/get-branch-id")
    public String getBranchUuidByTemporaryKey(@RequestParam("temporaryKey") String temporaryKey) {
        return this.tableRegister.getBranchUuidByTemporaryKey(temporaryKey);
    }

    @PostMapping("/get-table-uuid")
    public String getUuidByTemporaryKey(@RequestParam("temporaryKey") String temporaryKey) {
        return this.tableRegister.getUuidByTemporaryKey(temporaryKey);
    }

    @PostMapping("/add/table")
    public void insertTable(@RequestBody Table table) {

        System.out.println(" post mappings");
        if (!ObjectUtils.isEmpty(table.getUuid())) {
            throw new RuntimeException(" Крч айлди должен быть пустым");
        }
        this.tableRegister.insert(table);
    }

    @PostMapping("/delete/table/{uuid}")
    public void deleteTable(@PathVariable("uuid") String uuid) {
        this.tableRegister.delete(uuid);
    }
}
