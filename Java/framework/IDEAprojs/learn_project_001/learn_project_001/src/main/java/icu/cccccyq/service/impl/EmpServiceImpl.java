package icu.cccccyq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import icu.cccccyq.mapper.EmpMapper;
import icu.cccccyq.pojo.Emp;
import icu.cccccyq.pojo.PageBean;
import icu.cccccyq.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cccccyq
 */

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
//        //总记录数
//        Long count = empMapper.count();
//        //结果列表
//        Integer start = (page-1)*pageSize;
//        List<Emp> empList = empMapper.page(start,pageSize);
        //分页参数
        PageHelper.startPage(page, pageSize);
        //查询
        List<Emp> empList = empMapper.list();
        Page<Emp> p = (Page<Emp>) empList;
        //封装对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;

    }
}
