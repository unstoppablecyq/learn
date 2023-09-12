package icu.cccccyq.pojo;

/**
 * @author cccccyq
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询结果封装类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
    /**
     * 数据集合 用来返回分页结果集
     */
    private long total;
    /**
     * 总记录数
     */
    private List rows;
    /**
     * 数据列表
     */

}