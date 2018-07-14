package com.kason.app.dao;

import com.kason.app.entity.Property;

public interface PropertyMapper {
    int deleteByPrimaryKey(Integer proId);

    int insert(Property record);

    int insertSelective(Property record);

    Property selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}