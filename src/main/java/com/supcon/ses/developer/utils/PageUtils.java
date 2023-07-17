package com.supcon.ses.developer.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supcon.ses.developer.model.PageQuery;
import com.supcon.ses.developer.model.vo.PageVo;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *    分页工具类
 * </p>
 * @author lufengdong
 * @create 2022-12-12 10:37
 */
public class PageUtils {

    public static <T> IPage<T> generate(PageQuery params){ return generate(params.getPageNo(), params.getPageSize());}

    public static <T> IPage<T> generate(long pageNo){
        return generate(pageNo, PageQuery.DEFAULT_PAGE_SIZE);
    }

    public static <T> IPage<T> generate(long pageNo, long pageSize){
        if(pageNo <= 0){
            pageNo = PageQuery.DEFAULT_PAGE_NO;
        }
        if(pageSize <= 0){
            pageSize = PageQuery.DEFAULT_PAGE_SIZE;
        }
        return new Page<>(pageNo, pageSize);
    }
    /**
     * 获取伪分页中单页的返回数据
     * @param pageNo    页码
     * @param dataList  全部待分页数据
     * @param <T>
     */
    public static <T> List<T> fakePageList(long pageNo, List<T> dataList){
        return fakePageList(pageNo, PageQuery.DEFAULT_PAGE_SIZE, dataList);
    }
    /**
     * 获取伪分页中单页的返回数据
     * @param pageQuery 分页查询参数
     * @param dataList  全部待分页数据
     * @param <T>
     */
    public static <T> List<T> fakePageList(PageQuery pageQuery, List<T> dataList){
        return fakePageList(pageQuery.getPageNo(), pageQuery.getPageSize(), dataList);
    }
    /**
     * 获取伪分页中单页的返回数据
     * @param pageNo    页码
     * @param pageSize  页尺
     * @param dataList  全部待分页数据
     * @param <T>
     */
    public static <T> List<T> fakePageList(long pageNo, long pageSize, List<T> dataList){
        if(CollectionUtils.isEmpty(dataList)){
            return new ArrayList<>();
        }
        if(pageNo <= 0){
            pageNo = PageQuery.DEFAULT_PAGE_NO;
        }
        if(pageSize <= 0){
            pageSize = PageQuery.DEFAULT_PAGE_SIZE;
        }
        long total = dataList.size();
        long fromIndex = (pageNo - 1) *  pageSize;
        long toIndex = pageNo *  pageSize ;
        if(toIndex > total){
            toIndex = total;
        }
        return dataList.subList((int) fromIndex, (int) toIndex);
    }

    /**
     * 伪分页
     * @param pageQuery 分页查询对象
     * @param dataList  全部待分页数据
     * @param <T>
     */
    public static <T> PageVo<T> fakePage(PageQuery pageQuery, List<T> dataList){
        IPage<T> pageable = generate(pageQuery);
        return fakePage(pageable, dataList);
    }

    /**
     * 伪分页
     * @param pageNo    页码
     * @param pageSize  页尺
     * @param dataList  全部待分页数据
     * @param <T>
     */
    public static <T> PageVo<T> fakePage(long pageNo, long pageSize, List<T> dataList){
        IPage<T> pageable = generate(pageNo, pageSize);
        return fakePage(pageable, dataList);
    }

    /**
     * 伪分页
     * @param pageNo    页码
     * @param pageSize  页尺
     * @param dataList  全部待分页数据
     * @param <T>
     */
    public static <T> PageVo<T> fakePage(IPage<T> pageable, List<T> dataList){
        pageable.setTotal(dataList.size());
        List<T> recordList = fakePageList(pageable.getCurrent(), pageable.getSize(), dataList);
        pageable.setRecords(recordList);
        return convert(pageable);
    }

    /**
     * @param pageable mybatisPlus分页器
     * @return 数据上报工具通用分页对象
     * @param <T>
     */
    public static <T> PageVo<T> convert(IPage<T> pageable){
        PageVo<T> pageVo = new PageVo<>();
        pageVo.setPageNo(pageable.getCurrent());
        pageVo.setPageSize(pageable.getSize());
        pageVo.setCount(pageable.getTotal());
        pageVo.setContent(pageable.getRecords());
        return pageVo;
    }
}
