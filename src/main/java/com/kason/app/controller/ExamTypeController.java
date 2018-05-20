package com.kason.app.controller;


import com.kason.app.entity.ExamType;
import com.kason.app.entity.Result;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.ExamTypeService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/examtype")
public class ExamTypeController {

    @Autowired
    private ExamTypeService examTypeService;

    @GetMapping("/getall")
    public Result<ExamType> getAllExamType(){
        List<ExamType> typeList=examTypeService.getAllExamType();
        return ResultUtil.success(typeList);
    }

    @PostMapping("/add")
    public Result<ExamType> addExamType(@RequestBody ExamType examType){
        if(examType.getExamName()==null||"".equals(examType.getExamName())){
            throw new AppException(ResultEnum.EXAM_NAME_NULL);
        }
        if(examType.getCertificateTypeId()==null||examType.getCertificateTypeId()==0){
            throw new AppException(ResultEnum.CERTIFICATE_ID_NULL);
        }
        examTypeService.addExamType(examType);
        return ResultUtil.success();
    }

    @PostMapping("/update")
    public Result<ExamType> updateExamType(@RequestBody ExamType examType){
        if(examType.getId()==null||examType.getId()==0){
            throw new AppException(ResultEnum.EXAM_ID_NULL);
        }
        if(examType.getExamName()==null||"".equals(examType.getExamName())){
            throw new AppException(ResultEnum.EXAM_NAME_NULL);
        }
        if(examType.getCertificateTypeId()==null||examType.getCertificateTypeId()==0){
            throw new AppException(ResultEnum.CERTIFICATE_ID_NULL);
        }
        examTypeService.updateExamType(examType);
        return ResultUtil.success();
    }

    @GetMapping("/delete/{id}")
    public Result<ExamType> deleteExamType(@PathVariable(value = "id") Integer id){
        if(id==null||id==0){
            throw new AppException(ResultEnum.EXAM_ID_NULL);
        }
        examTypeService.deleteExamType(id);
        return ResultUtil.success();
    }

}
