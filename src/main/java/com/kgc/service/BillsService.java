package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.BillType;
import com.kgc.entity.Bills;
import com.kgc.utils.Param;

public interface BillsService {
    public PageInfo<Bills> getBillsByPage(Integer pageIndex, Integer pageSize, Param param);
    public boolean delete(Integer id);
    public Bills getBillsById(Integer id);
    public  boolean add(Bills bills);
    public  boolean update(Bills bills);
}
