package com.kgc.service.impl;

import com.kgc.entity.BillType;
import com.kgc.mapper.BillTypeMapper;
import com.kgc.service.BillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillTypeServiceImpl implements BillTypeService {
    @Autowired
    private BillTypeMapper billTypeMapper;
    @Override
    public List<BillType> getBillTypeList() {
        return billTypeMapper.selectByExample(null);
    }
}
