package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.BillType;
import com.kgc.entity.Bills;
import com.kgc.entity.BillsExample;
import com.kgc.mapper.BillTypeMapper;
import com.kgc.mapper.BillsMapper;
import com.kgc.service.BillsService;
import com.kgc.utils.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillsServiceImpl implements BillsService {
    @Autowired
    private BillsMapper billsMapper;
    @Autowired
    private BillTypeMapper billTypeMapper;


    @Override
    public PageInfo<Bills> getBillsByPage(Integer pageIndex, Integer pageSize, Param param) {
        BillsExample example=new BillsExample();
        BillsExample.Criteria criteria = example.createCriteria();
        if (param!=null){
            if (param.getTypeid()!=null&&param.getTypeid()!=-1){
                criteria.andTypeidEqualTo(param.getTypeid());
            }
            if (param.getMin_billtime()!=null){
                criteria.andBilltimeGreaterThanOrEqualTo(param.getMin_billtime());
            }
            if (param.getMax_billtime()!=null){
                criteria.andBilltimeLessThanOrEqualTo(param.getMax_billtime());
            }
        }
        PageHelper.startPage(pageIndex,pageSize);

        List<Bills> billsList = billsMapper.selectByExample(example);
        if (billsList!=null&&billsList.size()>0){
            for (Bills bills : billsList) {
                Integer id = bills.getTypeid();
                BillType billType = billTypeMapper.selectByPrimaryKey(id);
                bills.setBillType(billType);
            }
        }
        PageInfo<Bills> info=new PageInfo<>(billsList);
        return info;
    }

    @Override
    public boolean delete(Integer id) {
        return billsMapper.deleteByPrimaryKey(id)>0?true:false;
    }


    @Override
    public Bills getBillsById(Integer id) {
        Bills bills = billsMapper.selectByPrimaryKey(id);
        Integer typeid = bills.getTypeid();
        BillType billType = billTypeMapper.selectByPrimaryKey(typeid);
        bills.setBillType(billType);
        return bills;
    }

    @Override
    public boolean add(Bills bills) {
        return false;
    }

    @Override
    public boolean update(Bills bills) {
        return false;
    }

}
