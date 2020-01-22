package com.orypeu.excellent_course.common.entity;

import com.orypeu.excellent_course.common.config.Constant;
import com.orypeu.excellent_course.common.utils.ServletUtils;

/**
 * @ClassName TableSupport
 * @Description TODO 表格数据处理
 * @Author LJH
 * @Date 2020/1/20 11:21
 * @Version 1.0
 */
public class TableSupport {

    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(Constant.PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(Constant.PAGE_SIZE));
        pageDomain.setOrderByColumn(ServletUtils.getParameter(Constant.ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(Constant.IS_ASC));
        return pageDomain;
    }

    public static PageDomain buildPageRequest() {
        return getPageDomain();
    }
}
