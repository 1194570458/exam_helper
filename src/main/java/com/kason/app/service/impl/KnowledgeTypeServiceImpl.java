package com.kason.app.service.impl;

import com.kason.app.dao.KnowledgeTypeMapper;
import com.kason.app.entity.KnowledgeType;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.KnowledgeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KnowledgeTypeServiceImpl implements KnowledgeTypeService {

    @Autowired
    private KnowledgeTypeMapper knowledgeTypeMapper;

    /**
     * 添加综合知识的章节
     *
     * @param knowledgeType
     * @return
     */
    @Override
    public boolean addKnowledgeType(KnowledgeType knowledgeType) {
        if (knowledgeTypeMapper.selectByChapterAndDate(knowledgeType) != null) {
            throw new AppException(ResultEnum.KNOWLEDGE_TYPE_EXIST);
        }
        knowledgeType.setId(null);
        knowledgeTypeMapper.insertSelective(knowledgeType);
        return false;
    }

    /**
     * 根据章节的名字来查询
     *
     * @param knowledgeType
     * @return
     */
    @Override
    public KnowledgeType selectOneByTypeName(KnowledgeType knowledgeType) {
        return knowledgeTypeMapper.selectByChapter(knowledgeType);
    }

    /**
     * 根据章节的Id查询
     *
     * @param id
     * @return
     */
    @Override
    public KnowledgeType selectOneByTypeId(Integer id) {
        return knowledgeTypeMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新章节的信息
     *
     * @param knowledgeType
     * @return
     */
    @Override
    public KnowledgeType updateTypeById(KnowledgeType knowledgeType) {
        KnowledgeType type = knowledgeTypeMapper.selectByChapterAndDate(knowledgeType);
        if (type != null) {
            if (knowledgeType.getId() != type.getId())
                throw new AppException(ResultEnum.KNOWLEDGE_TYPE_EXIST);
            else return knowledgeType;
        }
        int i = knowledgeTypeMapper.updateByPrimaryKeySelective(knowledgeType);
        if (i > 0) {
            return knowledgeType;
        } else {
            return null;
        }
    }

    /**
     * 根据ID删除一个章节信息
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteTypeById(Integer id) {
        if (knowledgeTypeMapper.selectByPrimaryKey(id)==null) {
            throw new AppException(ResultEnum.KNOWLEDGE_TYPE_NULL);
        }
        return knowledgeTypeMapper.deleteByPrimaryKey(id) > 0 ? true : false;
    }

    /**
     * 获取所有章节信息
     *
     * @return
     */
    @Override
    public List<KnowledgeType> getKnowledgeTypes() {
        return knowledgeTypeMapper.selectAll();
    }
}
