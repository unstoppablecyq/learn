package icu.cccccyq.service;

import icu.cccccyq.pojo.Emp;
import icu.cccccyq.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * @author cccccyq
 */


public interface EmpService {
    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增
     * @param emp
     */
    void save(Emp emp);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 登录
     * @param emp
     * @return
     */
    Emp login(Emp emp);
}
