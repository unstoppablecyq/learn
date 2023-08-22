package icu.cccccyq.controller;

import icu.cccccyq.pojo.Result;
import icu.cccccyq.pojo.Emp;
import icu.cccccyq.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cccccyq
 * @date 2023/8/21 9:26
 */
@RestController
public class EmpController {
    @RequestMapping("/listEmp")
    public Result list(){
        //加载解析xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        //数据转换
        empList.stream().forEach(emp->{
            String gender = emp.getGender();
            if ("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }
            //处理job
            String job =  emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }

        });
        //响应数据
        return Result.success(empList);

    }
}




