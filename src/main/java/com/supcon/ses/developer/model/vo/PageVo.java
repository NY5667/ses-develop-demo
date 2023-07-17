package com.supcon.ses.developer.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>
 *     通用数据上报分页返回结果
 * </p>
 * @author lufengdong
 * @create 2022-11-04 17:13
 */
@Getter
@Setter
public class PageVo<T> {

    private long pageNo;

    private long pageSize;

    private long count;

    private List<T> content;
}
