package com.kason.app.controller;

import com.kason.app.entity.Result;
import com.kason.app.entity.Synthesize;
import com.kason.app.service.SynthesizeService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SynthesizeController {

    @Autowired
    private SynthesizeService synthesizeService;

    /**
     * 添加或者更新题目
     * @param synthesize
     * @return
     */
    @PostMapping("/synthesize")
    public Result<Synthesize> Synthesize(@RequestBody Synthesize synthesize){
        Synthesize s ;
        if(synthesize.getSynId()==null){
            if (synthesize.getTitle()==null) {
                return ResultUtil.error(-1,"题目不能为空");
            }
            if (synthesize.getSelect()==null) {
                return ResultUtil.error(-1,"选项不能为空");
            }
            if (synthesize.getResult()==null) {
                return ResultUtil.error(-1,"答案不能为空");
            }
            if(synthesize.getProId()==null){
                return ResultUtil.error(-1,"章节id不能为空");
            }
            if(synthesize.getCerId()==null){
                return ResultUtil.error(-1,"证书id不能为空");
            }
            s = synthesizeService.addSynthesize(synthesize);
        }else {
            s = synthesizeService.updateSynthesize(synthesize);
        }
        return ResultUtil.success(s);
    }

    /**
     * 获取所有题目
     * @return
     */
    @GetMapping("/synthesizes")
    public Result<Synthesize> getSynthesizes(){
        List<Synthesize> synthesizes= synthesizeService.getSynthesizes();
        return ResultUtil.success(synthesizes);
    }

    /**
     * 根据id获取题目
     * @param id
     * @return
     */
    @GetMapping("/synthesize/{id}")
    public Result<Synthesize> getSynthesize(@PathVariable("id") Integer id){
        Synthesize synthesize= synthesizeService.getSynthesize(id);
        return ResultUtil.success(synthesize);
    }

    /**
     * 根据id删除题目
     * @param id
     * @return
     */
    @PostMapping("/synthesize/{id}")
    public Result<Synthesize> delSynthesize(@PathVariable("id") Integer id){
        synthesizeService.delSynthesize(id);
        return ResultUtil.success();
    }

    /**
     * 根据证书id和章节id获取题目
     * @param cerId
     * @param proId
     * @return
     */
    @GetMapping("/synthesize/{cerId}/{proId}")
    public Result<Synthesize> getSynthesize(@PathVariable("cerId") Integer cerId,@PathVariable("proId")Integer proId){
        return ResultUtil.success(synthesizeService.getSynthesize(cerId,proId));
    }

}
