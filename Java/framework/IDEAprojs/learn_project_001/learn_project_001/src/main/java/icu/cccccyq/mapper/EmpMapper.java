package icu.cccccyq.mapper;

import icu.cccccyq.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * @author cccccyq
 */
@Mapper
public interface EmpMapper {

//    @Select("select count(*) from emp")
//    public Long count();
//
//    /**
//     * 页面分页查询
//     * @param start
//     * @param pageSize
//     * @return
//     */
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start,Integer pageSize);

//    @Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    /**
     * id单个查询
     * @param id
     * @return
     */
    @Select("select * from emp where id=#{id}")
    Emp getById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 通过用户名和密码查询
     * @param emp
     * @return
     */
    @Select("Select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /**
     * 通过部门ID删除员工
     * @param deptId
     */
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
