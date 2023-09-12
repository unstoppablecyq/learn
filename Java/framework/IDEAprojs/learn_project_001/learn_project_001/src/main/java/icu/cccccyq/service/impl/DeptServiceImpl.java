package icu.cccccyq.service.impl;

import icu.cccccyq.mapper.DeptMapper;
import icu.cccccyq.mapper.EmpMapper;
import icu.cccccyq.pojo.Dept;
import icu.cccccyq.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author cccccyq
 */

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {

        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
//        int i = 1/0;
        empMapper.deleteByDeptId(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @Override
    public List<Dept> search(Integer id) {

        return deptMapper.search(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateById(dept);
    }
}
