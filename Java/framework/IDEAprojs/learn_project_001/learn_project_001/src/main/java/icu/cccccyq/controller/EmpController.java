package icu.cccccyq.controller;

import icu.cccccyq.anno.Log;
import icu.cccccyq.pojo.Emp;
import icu.cccccyq.pojo.PageBean;
import icu.cccccyq.pojo.Result;
import icu.cccccyq.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author cccccyq
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping()
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end ){
        log.info("search");
        //service分页
        PageBean pageBean = empService.page(page,pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除, {}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @Log
    @PostMapping()
    public Result save(@RequestBody Emp emp){
            log.info("new:{}", emp);
            empService.save(emp);
            return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("id->emps:{}", id);

        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @Log
    @PutMapping()
    public Result update(@RequestBody Emp emp) {
        log.info("update emp : {}", emp);
        empService.update(emp);
        return Result.success();
    }
}
