package icu.cccccyq;

import icu.cccccyq.mapper.UserMapper;
import icu.cccccyq.pojo.User;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TestMybatis0ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testListUser(){
        List<User> userList = userMapper.list();
        userList.stream().forEach(user -> {
            System.out.println(user);
        });
    }


}
