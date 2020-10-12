package com.artcreation.group.stock.utils;

/**
 * @Author: linjie
 * @Date: 2019-08-06 15:53
 */
public class PageObject {
    Integer page;

    Long count;

    Integer pageSize;

    Integer pageCount;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public  static PageObject makePage(Integer page,Integer pageSize,Integer count){
        PageObject pageObject = new PageObject();
        pageObject.setPage(page);
        pageObject.setPageSize(pageSize);
        pageObject.setPageCount(count);

        Double pageCount = Math.ceil(count*1.0/pageSize*1.0);

        pageObject.setPageCount(pageCount.intValue());

        return pageObject;

    }

}
