package com.kason.app.controller;

import com.kason.app.entity.Case;
import com.kason.app.entity.Result;
import com.kason.app.entity.Synthesize;
import com.kason.app.service.CaseService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CaseController {

    @Autowired
    private CaseService caseService;

    /**
     * 添加或者更新案例
     * @param c
     * @return
     */
    @PostMapping("/case")
    public Result<Case> addOrUpdateCase(@RequestBody Case c) {
        Case ca;
        if (c.getCaseId() == null) {
            if (c.getTitle() == null) return ResultUtil.error(-1, "标题不能为空");
            if (c.getContent() == null) return ResultUtil.error(-1, "内容不能为空");
            if (c.getProId() == null) return ResultUtil.error(-1, "章节id不能为空");
            if (c.getCerId() == null) return ResultUtil.error(-1, "证书id不能为空");
            ca = caseService.addCase(c);
        } else {
            ca = caseService.updateCase(c);
        }
        return ResultUtil.success(ca);
    }

    /**
     * 获取全部案例
     * @return
     */
    @GetMapping("/cases")
    public Result<List<Case>> getCases(){
        return ResultUtil.success(caseService.getCases());
    }

    /**
     * 根据id删除案例
     * @param id
     * @return
     */
    @PostMapping("/case/{id}")
    public Result delCase(@PathVariable("id") Integer id){
        caseService.delCase(id);
        return ResultUtil.success();
    }

    /**
     * 根据id获取案例
     * @param id
     * @return
     */
    @GetMapping("/case/{id}")
    public Result<Case> getCase(@PathVariable("id")Integer id){
        Case c = caseService.getCase(id);
        return ResultUtil.success(c);
    }

    /**
     * 根据证书id和章节id获取案例
     * @param cerId
     * @param proId
     * @return
     */
    @GetMapping("/case/{cerId}/{proId}")
    public Result<Case> getCase(@PathVariable("cerId") Integer cerId, @PathVariable("proId")Integer proId){
        return ResultUtil.success(caseService.getCase(cerId,proId));
    }


}
