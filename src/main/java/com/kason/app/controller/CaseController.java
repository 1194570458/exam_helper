package com.kason.app.controller;

import com.kason.app.entity.Case;
import com.kason.app.entity.Result;
import com.kason.app.service.CaseService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CaseController {

    @Autowired
    private CaseService caseService;

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

}
