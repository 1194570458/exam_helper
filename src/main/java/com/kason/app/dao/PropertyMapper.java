package com.kason.app.dao;

import com.kason.app.entity.Property;

import java.util.List;

public interface PropertyMapper {
    int deleteByPrimaryKey(Integer proId);

    int insert(Property record);

    int insertSelective(Property record);

    Property selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);

    List<Property> selectAll();
}