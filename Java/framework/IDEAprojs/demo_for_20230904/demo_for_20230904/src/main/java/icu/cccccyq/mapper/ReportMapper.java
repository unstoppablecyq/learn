package icu.cccccyq.mapper;

import icu.cccccyq.pojo.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cccccyq
 */
@Mapper
public interface ReportMapper {
    @Select("select count(*) from ` work_hours`")
    public Long count();

    /**
     * 页面分页查询
     * @param start
     * @param pageSize
     * @return
     */
    @Select("select * from ` work_hours` order by work_date desc limit #{start},#{pageSize} ")
    public List<Report> page(Integer start, Integer pageSize);
}