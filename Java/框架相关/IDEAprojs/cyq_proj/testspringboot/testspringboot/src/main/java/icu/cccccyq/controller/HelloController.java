package icu.cccccyq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cccccyq
 * @date 2023/8/16 14:07
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("testsb");
        return "testsb";
    }
}
//test