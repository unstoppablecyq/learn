package icu.cccccyq.controller;

import icu.cccccyq.pojo.Emp;
import icu.cccccyq.pojo.Result;
import icu.cccccyq.service.EmpService;
import icu.cccccyq.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author cccccyq
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;
    
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("login:{}",emp);
        Emp e = empService.login(emp);

        if(e != null){
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());
            
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }

        return Result.error("登录失败");

    }
}