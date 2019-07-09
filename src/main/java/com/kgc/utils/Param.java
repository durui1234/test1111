package com.kgc.utils;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Param {
    private Integer typeid;
    private Date min_billtime;
    private Date max_billtime;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Date getMin_billtime() {
        return min_billtime;
    }
@DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setMin_billtime(Date min_billtime) {
        this.min_billtime = min_billtime;
    }

    public Date getMax_billtime() {
        return max_billtime;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setMax_billtime(Date max_billtime) {
        this.max_billtime = max_billtime;
    }
}
