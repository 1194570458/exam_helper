package com.kason.app.service.impl;

import com.kason.app.dao.ExamTypeMapper;
import com.kason.app.entity.ExamType;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.ExamTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExamTypeServiceImpl implements ExamTypeService {

    @Autowired
    private ExamTypeMapper examTypeMapper;

    /**
     * 获取所有软考类型
     *
     * @return
     */
    @Override
    public List<ExamType> getAllExamType() {
        return examTypeMapper.selectAll();
    }

    /**
     * 添加一个软考类型
     *
     * @param examType
     */
    @Override
    public void addExamType(ExamType examType) {
        if (examTypeMapper.selectByName(examType.getExamName()) != null) {
            throw new AppException(ResultEnum.EXAM_EXIST);
        }
        examTypeMapper.insertSelective(examType);
    }

    /**
     * 根据ID更新软考类型信息
     *
     * @param examType
     */
    @Override
    public void updateExamType(ExamType examType) {
        if (examTypeMapper.selectByPrimaryKey(examType.getId()) == null) {
            throw new AppException(ResultEnum.EXAM_NULL);
        }
        ExamType type = examTypeMapper.selectByName(examType.getExamName());
        if (type != null) {
            if (examType.getId() != type.getId() && examType.getExamName().equals(examType.getExamName())) {
                throw new AppException(ResultEnum.EXAM_EXIST);
            }
        }
        examTypeMapper.updateByPrimaryKeySelective(examType);

    }

    /**
     * 根据ID删除软考类型信息
     *
     * @param id
     */
    @Override
    public void deleteExamType(Integer id) {
        if (examTypeMapper.selectByPrimaryKey(id) == null) {
            throw new AppException(ResultEnum.EXAM_NULL);
        }
        examTypeMapper.deleteByPrimaryKey(id);
    }
}
