package icu.cccccyq.service;

import icu.cccccyq.pojo.Dept;

import java.util.List;

/**
 * @author cccccyq
 */

public interface DeptService {
    /**
     * 查询全部数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    List<Dept> search(Integer id);

    /**
     * 修改信息
     * @param dept
     */
    void update(Dept dept);
}
