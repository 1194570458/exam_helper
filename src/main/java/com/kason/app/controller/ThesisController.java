package com.kason.app.controller;

import com.kason.app.entity.Result;
import com.kason.app.entity.Synthesize;
import com.kason.app.entity.Thesis;
import com.kason.app.service.ThesisService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ThesisController {

    @Autowired
    private ThesisService thesisService;

    /**
     * 添加或者更新论文
     * @param thesis
     * @return
     */
    @PostMapping("/thesis")
    public Result<Thesis> thesis(@RequestBody Thesis thesis) {
        Thesis t;
        if (thesis.getThesisId() == null) {
            if (thesis.getTitle() == null) {
                return ResultUtil.error(-1, "标题不能为空");
            }
            if (thesis.getContent() == null) {
                return ResultUtil.error(-1, "文章不能为空");
            }
            if (thesis.getProId() == null) {
                return ResultUtil.error(-1, "章节id不能为空");
            }
            if (thesis.getCerId() == null) {
                return ResultUtil.error(-1, "证书id不能为空");
            }
            t = thesisService.addThesis(thesis);
        } else {
            t = thesisService.updateThesis(thesis);
        }
        return ResultUtil.success(t);
    }

    /**
     * 根据id获取论文
     * @param id
     * @return
     */
    @GetMapping("/thesis/{id}")
    public Result<Thesis> getThesis(@PathVariable("id") Integer id){
        Thesis t = thesisService.getThesis(id);
        return ResultUtil.success(t);
    }

    /**
     * 获取全部论文
     * @return
     */
    @GetMapping("/theses")
    public Result<List<Thesis>> getTheses(){
        List<Thesis> theses = thesisService.getTheses();
        return ResultUtil.success(theses);
    }

    /**
     * 根据id获取论文
     * @param id
     * @return
     */
    @PostMapping("/thesis/{id}")
    public Result delThesis(@PathVariable("id") Integer id){
        thesisService.delThesis(id);
        return ResultUtil.success();
    }

    /**
     * 根据证书id和章节id获取题目
     * @param cerId
     * @param proId
     * @return
     */
    @GetMapping("/thesis/{cerId}/{proId}")
    public Result<Thesis> getThesis(@PathVariable("cerId") Integer cerId, @PathVariable("proId")Integer proId){
        return ResultUtil.success(thesisService.getThesis(cerId,proId));
    }

}
