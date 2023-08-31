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

    private long total;
    private List rows;

}