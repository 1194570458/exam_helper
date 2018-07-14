package com.kason.app.dao;

import com.kason.app.entity.Thesis;

public interface ThesisMapper {
    int deleteByPrimaryKey(Integer thesisId);

    int insert(Thesis record);

    int insertSelective(Thesis record);

    Thesis selectByPrimaryKey(Integer thesisId);

    int updateByPrimaryKeySelective(Thesis record);

    int updateByPrimaryKey(Thesis record);
}