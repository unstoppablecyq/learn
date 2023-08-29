package icu.cccccyq.mapper;


import icu.cccccyq.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cccccyq
 */
@Mapper
public interface UserMapper {
    /**
     * 查询全部用户信息
     */
    @Select("select * from user")
    public List<User> list();
}
//test