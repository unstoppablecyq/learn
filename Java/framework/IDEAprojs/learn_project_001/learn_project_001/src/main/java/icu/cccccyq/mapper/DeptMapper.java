package icu.cccccyq.mapper;

import icu.cccccyq.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author cccccyq
 */
@Mapper
public interface DeptMapper {
    @Select("select * from cyq_project_001.dept")
    List<Dept> list();

    /**
     * id删除内容
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
    @Insert("insert into dept(name,create_time,update_time) " +
            "values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Select("select * from dept where id = #{id}")
    List<Dept> search(Integer id);

    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void updateById(Dept dept);
}
