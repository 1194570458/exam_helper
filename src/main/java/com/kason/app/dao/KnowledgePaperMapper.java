package com.kason.app.dao;

import com.kason.app.entity.KnowledgePaper;

public interface KnowledgePaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KnowledgePaper record);

    int insertSelective(KnowledgePaper record);

    KnowledgePaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KnowledgePaper record);

    int updateByPrimaryKey(KnowledgePaper record);
}