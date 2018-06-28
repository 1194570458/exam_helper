package com.kason.app.service;

import com.kason.app.entity.KnowledgePaper;

import java.util.List;

public interface KnowledgePaperService {

    void addKnowledgePaper(KnowledgePaper knowledgePaper);

    List<KnowledgePaper> getKnowledgePapersByKnowledgeTypeId(Integer id);



}
