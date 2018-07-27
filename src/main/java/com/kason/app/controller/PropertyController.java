package com.kason.app.controller;

import com.kason.app.entity.Property;
import com.kason.app.entity.Result;
import com.kason.app.service.PropertyService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    /**
     * 更新或者添加章节
     *
     * @param property
     * @return
     */
    @PostMapping("/property")
    public Result<Property> Property(@RequestBody Property property) {
        Property p = null;
        if (property.getProId() == null) {
            if (property.getChapter() == null) {
                return ResultUtil.error(-1, "章节名不能为空");
            }
            if (property.getTime() == null) {
                return ResultUtil.error(-1, "时间不能为空");
            }
            p = propertyService.addProperty(property);
        } else if (property.getProId() > 0) {
            p = propertyService.updateProperty(property);
        } else {
            return ResultUtil.error(-1, "id格式错误");
        }
        return ResultUtil.success(p);
    }

    /**
     * 获取所有章节
     * @return
     */
    @GetMapping("/propertys")
    public Result<List<Property>> getPropertys(){
        List<Property> properties=propertyService.getPropertys();
        return ResultUtil.success(properties);
    }

    /**
     * 根据id获取章节
     * @param id
     * @return
     */
    @GetMapping("/property/{id}")
    public Result<Property> getProperty(@PathVariable("id") Integer id){
        Property p =propertyService.getProperty(id);
        return ResultUtil.success(p);
    }

    @GetMapping("/property/new/{id}")
    public Result<Property> getNewProperties(@PathVariable("id") Integer id){
        List<Property> p =propertyService.getNewPropertys(id);
        return ResultUtil.success(p);
    }

    /**
     * 根据id删除章节
     * @param id
     * @return
     */
    @PostMapping("/property/{id}")
    public Result<Property> delProperty(@PathVariable Integer id){
        propertyService.delProperty(id);
        return  ResultUtil.success();
    }

}
