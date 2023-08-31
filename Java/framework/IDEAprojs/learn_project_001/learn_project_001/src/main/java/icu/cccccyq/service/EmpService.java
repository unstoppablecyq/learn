package icu.cccccyq.service;

import icu.cccccyq.pojo.PageBean;

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
    PageBean page(Integer page, Integer pageSize);
}
