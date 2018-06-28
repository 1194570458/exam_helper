package com.kason.app.service;

import com.kason.app.entity.KnowledgeType;

import java.util.List;

public interface KnowledgeTypeService {


    boolean addKnowledgeType(KnowledgeType knowledgeType);

    KnowledgeType selectOneByTypeName(KnowledgeType knowledgeType);

    KnowledgeType selectOneByTypeId(Integer id);

    KnowledgeType updateTypeById(KnowledgeType knowledgeType);

    boolean deleteTypeById(Integer id);

    List<KnowledgeType> getKnowledgeTypes();
}
