package com.kason.app.dao;

import com.kason.app.entity.Thesis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ThesisMapper {
    int deleteByPrimaryKey(Integer thesisId);

    int insert(Thesis record);

    int insertSelective(Thesis record);

    Thesis selectByPrimaryKey(Integer thesisId);

    int updateByPrimaryKeySelective(Thesis record);

    int updateByPrimaryKey(Thesis record);

    List<Thesis> selectAll();

    List<Thesis> selectByCerIdAndProId(@Param("cerId") Integer cerId, @Param("proId") Integer proId);
}