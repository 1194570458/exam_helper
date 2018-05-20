package com.kason.app.controller;


import com.kason.app.entity.Manager;
import com.kason.app.entity.Member;
import com.kason.app.entity.Result;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.ManagerService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin

@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping(value = "/login")
    public Result<Manager> managerLogin(@RequestBody Manager manager) {
        if (manager.getUsername() == null || "".equals(manager.getUsername())) {
            throw new AppException(ResultEnum.MANAGER_USERNAME_NULL);
        }
        if (manager.getPassword() == null || "".equals(manager.getPassword())) {
            throw new AppException(ResultEnum.MANAGER_PASSWORD_NULL);
        }
        manager = managerService.getManager(manager);
        if (manager == null) {
            throw new AppException(ResultEnum.MANAGER_LOGIN_ERROR);
        }
        return ResultUtil.success(manager);
    }
}
