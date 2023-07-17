package com.supcon.ses.developer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 *    通用分页查询对象
 * </p>
 * @author lufengdong
 * @create 2022-09-12 14:03
 */
@Setter
@ApiModel(value = "分页器")
@NoArgsConstructor
@AllArgsConstructor
public class PageQuery{

    @ApiModelProperty(value = "页码", required = true, position = 100)
    private long pageNo;

    @ApiModelProperty(value = "页尺", required = true, position = 101)
    private long pageSize;
    /**
     * 默认页码
     */
    public static final int DEFAULT_PAGE_NO = 1;
    /**
     * 默认每页显示的记录数
     */
    public static final int DEFAULT_PAGE_SIZE = 20;

    public long getPageNo() {
        return pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

}
