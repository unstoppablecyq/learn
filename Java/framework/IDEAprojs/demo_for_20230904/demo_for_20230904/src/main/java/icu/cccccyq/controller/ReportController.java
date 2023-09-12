package icu.cccccyq.controller;

import icu.cccccyq.pojo.PageBean;
import icu.cccccyq.pojo.Result;
import icu.cccccyq.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cccccyq
 */
@Slf4j
@RequestMapping("WorkingHourApply/Index")
@RestController
public class ReportController {
    //引入ReportService
    @Autowired
    private ReportService reportService;
    //查询首页的人员所有工作时间的提交情况
    @PostMapping()
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页展示");

        PageBean pageBean =  reportService.page(page,pageSize);

        return Result.success(pageBean);
    }

}