package icu.cccccyq.controller;

import icu.cccccyq.pojo.PageBean;
import icu.cccccyq.pojo.Result;
import icu.cccccyq.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询：{}，{}", page, pageSize);
        //service分页
        PageBean pageBean = empService.page(page,pageSize);
        return Result.success(pageBean);
    }

}
