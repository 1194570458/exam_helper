package com.kason.app.service;

import com.kason.app.entity.ExamType;

import java.util.List;

public interface ExamTypeService {

    List<ExamType> getAllExamType();

    void addExamType(ExamType examType);

    void updateExamType(ExamType examType);

    void deleteExamType(Integer id);

}
