package com.kgc.mapper;

import com.kgc.entity.BillType;
import com.kgc.entity.BillTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillTypeMapper {
    int countByExample(BillTypeExample example);

    int deleteByExample(BillTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BillType record);

    int insertSelective(BillType record);

    List<BillType> selectByExample(BillTypeExample example);

    BillType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BillType record, @Param("example") BillTypeExample example);

    int updateByExample(@Param("record") BillType record, @Param("example") BillTypeExample example);

    int updateByPrimaryKeySelective(BillType record);

    int updateByPrimaryKey(BillType record);
}