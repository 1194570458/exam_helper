package com.kason.app.dao;

import com.kason.app.entity.Synthesize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SynthesizeMapper {
    int deleteByPrimaryKey(Integer synId);

    int insert(Synthesize record);

    int insertSelective(Synthesize record);

    Synthesize selectByPrimaryKey(Integer synId);

    int updateByPrimaryKeySelective(Synthesize record);

    int updateByPrimaryKey(Synthesize record);

    List<Synthesize> selectByCerIdAndProId(@Param("cerId") Integer cerId, @Param("proId") Integer proId);

    List<Synthesize> selectAll();
}