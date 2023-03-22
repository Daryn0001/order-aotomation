package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.TableDetails;
import kz.sdu.stu.dsalimov.register.TableRegister;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app"})
@RequestMapping(value = "/api")
public class TableController {
    private final TableRegister tableRegister;

    @GetMapping("/tables")
    public ResponseEntity<List<TableDetails>> getTables() {
        List<TableDetails> tables = this.tableRegister.getTables();
        System.out.println(" get mappings tb: " + tables);
        return new ResponseEntity<>(
                tables,
                HttpStatus.OK
        );
    }

    @GetMapping("/test")
    public ResponseEntity<Test> test() {
        Test t = new Test("test1", "test2", 5);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @GetMapping("/getTable/{uuid}")
    public @ResponseBody ResponseEntity<TableDetails> getTableById(@PathVariable("uuid") String uuid) {
        System.out.println(" found by id: " + this.tableRegister.findById(uuid));
        return new ResponseEntity<>(
                this.tableRegister.findById(uuid),
                HttpStatus.OK
        );
    }

    @GetMapping("/table/{uuid}")
    public ResponseEntity<TableDetails> getTable(@PathVariable("uuid") String uuid) {
        return new ResponseEntity<>(this.tableRegister.findById(uuid), HttpStatus.OK);
    }

    @PostMapping("/add/table")
    public void insertTable(@RequestBody TableDetails table) {

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

@AllArgsConstructor
@Data
class Test {
    private String test1;
    private String test2;
    private int test3;
}