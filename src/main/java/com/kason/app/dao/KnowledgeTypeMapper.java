package com.kason.app.dao;

import com.kason.app.entity.KnowledgeType;

import java.util.List;

public interface KnowledgeTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KnowledgeType record);

    int insertSelective(KnowledgeType record);

    KnowledgeType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KnowledgeType record);

    int updateByPrimaryKey(KnowledgeType record);

    //根据名字和日期查找
    KnowledgeType selectByChapterAndDate(KnowledgeType knowledgeType);

    //根据名字查找
    KnowledgeType selectByChapter(KnowledgeType knowledgeType);

    //查找全部
    List<KnowledgeType> selectAll();
}