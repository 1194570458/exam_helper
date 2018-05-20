package com.kason.app.dao;

import com.kason.app.entity.ExamType;

import java.util.List;

public interface ExamTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamType record);

    int insertSelective(ExamType record);

    ExamType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamType record);

    int updateByPrimaryKey(ExamType record);

    List<ExamType> selectAll();

    ExamType selectByName(String name);

    ExamType selectByCertificateTypeId(Integer certificateTypeId);
}