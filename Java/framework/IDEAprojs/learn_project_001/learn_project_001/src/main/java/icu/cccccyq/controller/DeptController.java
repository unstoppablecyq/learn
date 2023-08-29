package icu.cccccyq.controller;

import icu.cccccyq.pojo.Dept;
import icu.cccccyq.pojo.Result;
import icu.cccccyq.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cccccyq
 */
/*部门管理*/
@Slf4j
@RequestMapping("depts")
@RestController
public class DeptController {

//    private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    @GetMapping()
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    public Result list(){
        log.info("查询全部数据");
//        System.out.println("查询全部数据");

        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除id对应内容");

        deptService.delete(id);
        return Result.success();
    }

//    新增
    @PostMapping()
    public Result add(@RequestBody Dept dept){
        log.info("新增内容:{}",dept);

        deptService.add(dept);
        return Result.success();
    }
}
