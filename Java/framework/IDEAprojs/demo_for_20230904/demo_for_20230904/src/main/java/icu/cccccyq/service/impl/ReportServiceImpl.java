package icu.cccccyq.service.impl;

import icu.cccccyq.mapper.ReportMapper;
import icu.cccccyq.pojo.PageBean;
import icu.cccccyq.pojo.Report;
import icu.cccccyq.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cccccyq
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageBean page(Integer page, Integer pageSize) {

        Long count = reportMapper.count();//  查询记录数
        Integer start = (page-1) * pageSize;
        List<Report> reportList = reportMapper.page(start,pageSize);
        //  返回数据
        PageBean pageBean = new PageBean(count, reportList);
        return pageBean;
    }
}