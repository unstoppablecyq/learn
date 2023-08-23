package icu.cccccyq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cccccyq
 * @date 2023/8/16 14:07
 */
@RestController
public class HelloController {
    @RequestMapping("/param1")
    public String param1(@RequestParam(name = "name", required = false) String name, Integer age){
        System.out.println(name+":"+age);
        return "ok";
    }
}
//test