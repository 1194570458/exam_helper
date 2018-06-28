package com.kason.app.controller;


import com.kason.app.entity.KnowledgeType;
import com.kason.app.entity.Result;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.KnowledgeTypeService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/kenowledgetype")
public class KnowledgeTypeController {

    @Autowired
    private KnowledgeTypeService service;

    @PostMapping(value = "add")
    public Result<KnowledgeType> addKnowledgeType(@RequestBody KnowledgeType knowledgeType) {
        if (knowledgeType.getChapter() == null || knowledgeType.getChapter().trim().equals("")) {
            throw new AppException(ResultEnum.KNOWLEDGE_CHAPTER_NULL);
        }
        if (knowledgeType.getDate() == null) {
            throw new AppException(ResultEnum.KNOWLEDGE_DATE_NULL);
        }
        service.addKnowledgeType(knowledgeType);
        return ResultUtil.success();
    }

    @GetMapping(value = "getall")
    public Result<KnowledgeType> getAllKnowledgeType() {
        return ResultUtil.success(service.getKnowledgeTypes());
    }

    @GetMapping(value = "delete/{id}")
    public Result<KnowledgeType> deleteKnowledgeType(@PathVariable(value = "id") Integer id) {
        service.deleteTypeById(id);
        return ResultUtil.success();
    }

    @PostMapping("update")
    public Result<KnowledgeType> updateKnowledgeType(@RequestBody KnowledgeType knowledgeType) {
        if (knowledgeType.getId() == null || knowledgeType.getId() <= 0) {
            throw new AppException(ResultEnum.KNOWLEDGE_ID_NULL);
        }
        if (knowledgeType.getDate() == null) {
            throw new AppException(ResultEnum.KNOWLEDGE_DATE_NULL);
        }
        if (knowledgeType.getChapter() == null || knowledgeType.getChapter().trim().equals("")) {
            throw new AppException(ResultEnum.KNOWLEDGE_CHAPTER_NULL);
        }
        knowledgeType = service.updateTypeById(knowledgeType);
        if (knowledgeType == null) {
            throw new AppException(ResultEnum.KNOWLEDGE_ERROR);
        }
        return ResultUtil.success(knowledgeType);
    }

}
