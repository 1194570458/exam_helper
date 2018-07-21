package com.kason.app.dao;

import com.kason.app.entity.Case;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CaseMapper {
    int deleteByPrimaryKey(Integer caseId);

    int insert(Case record);

    int insertSelective(Case record);

    Case selectByPrimaryKey(Integer caseId);

    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKey(Case record);

    List<Case> selectAll();

    List<Case> selectByCerIdAndProId(@Param("cerId") Integer cerId, @Param("proId") Integer proId);
}