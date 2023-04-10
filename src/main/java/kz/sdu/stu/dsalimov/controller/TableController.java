package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.Tables;
import kz.sdu.stu.dsalimov.dto.response.SuccessResponse;
import kz.sdu.stu.dsalimov.register.TableRegister;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://order-automation-frontend-lake.vercel.app"})
@RequestMapping(value = "/api")
public class TableController {
    private final TableRegister tableRegister;

    @GetMapping("/tables")
    public ResponseEntity<SuccessResponse> getTables() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        List<Tables> tables = this.tableRegister.getTables();
        System.out.println(" get mappings tb: " +  tables);
        return new ResponseEntity<>(
                new SuccessResponse(tables, MessageFormat.format("{0}, Result found", tables.size())),
                HttpStatus.OK
        );
    }

    @GetMapping("/test")
    public ResponseEntity<Test> test() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Test t = new Test("test1", "test2", 5);
        return new ResponseEntity<>(t, headers, HttpStatus.OK);
    }

    @GetMapping("/getTable/{uuid}")
    public @ResponseBody Tables getTableById(@PathVariable("uuid") String uuid) {
        System.out.println(" found by id: " + this.tableRegister.findById(uuid));
        return this.tableRegister.findById(uuid);
    }

    @GetMapping("/table/{uuid}")
    public ResponseEntity<Tables> getTable(@PathVariable("uuid") String uuid) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(this.tableRegister.findById(uuid), headers, HttpStatus.OK);
    }

    @PostMapping("/add/table")
    public void insertTable(@RequestBody Tables table) {

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