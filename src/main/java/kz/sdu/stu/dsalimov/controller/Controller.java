package kz.sdu.stu.dsalimov.controller;

import kz.sdu.stu.dsalimov.dto.db.TableDetails;
import kz.sdu.stu.dsalimov.dto.db.response.SuccessResponse;
import kz.sdu.stu.dsalimov.register.TableRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class Controller {
    private final TableRegister tableRegister;

    @GetMapping("/tables")
    public ResponseEntity<SuccessResponse> getTables() {

        List<TableDetails> tables = this.tableRegister.getTables();
        System.out.println(" get mappings: " +tables);

        return new ResponseEntity<>(
                new SuccessResponse(tables, MessageFormat.format("{0}, Result found", tables.size())),
                HttpStatus.OK
        );
    }

    @GetMapping("/getTable/{uuid}")
    public @ResponseBody TableDetails getTableById(@PathVariable("uuid") String uuid) {
        System.out.println(" found by id: " + this.tableRegister.findById(uuid));
        return this.tableRegister.findById(uuid);
    }

    @GetMapping("/table/{uuid}")
    public ResponseEntity<TableDetails> getTable(@PathVariable("uuid") String uuid) {
        return new ResponseEntity<>(this.tableRegister.findById(uuid), HttpStatus.OK);
    }

    @PostMapping("/add/table")
    public void insertTable(@RequestBody TableDetails table) {

        System.out.println(" post mappings");
        if (!ObjectUtils.isEmpty(table.uuid())) {
            throw new RuntimeException(" Крч таокй айди есть уже");
        }
        this.tableRegister.insert(table);
    }

    @PostMapping("/delete/table/{uuid}")
    public void deleteTable(@PathVariable("uuid") String uuid) {
        this.tableRegister.delete(uuid);
    }
}
