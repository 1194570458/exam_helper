package com.kason.app.dao;

import com.kason.app.entity.Synthesize;

public interface SynthesizeMapper {
    int deleteByPrimaryKey(Integer synId);

    int insert(Synthesize record);

    int insertSelective(Synthesize record);

    Synthesize selectByPrimaryKey(Integer synId);

    int updateByPrimaryKeySelective(Synthesize record);

    int updateByPrimaryKey(Synthesize record);
}