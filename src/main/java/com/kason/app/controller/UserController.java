package com.kason.app.controller;

import com.kason.app.entity.Result;
import com.kason.app.entity.User;
import com.kason.app.service.UserService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户或者更新用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/user")
    public Result<User> user(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null || password == null) {
            return ResultUtil.error(-1, "账号或者密码不能为空");
        }
        if ("".equals(username.trim()) || "".equals(password.trim())) {
            return ResultUtil.error(-1, "账号或者密码不能为空");
        }
        User u = null;
        if (user.getUserId() == null) {
            if (user.getCerId()==null) {
                return ResultUtil.error(-1,"证书id错误");
            }
            if (user.getCerId()<=0) {
                return ResultUtil.error(-1,"证书id错误");
            }
            u = userService.addUser(user);
        } else if (user.getUserId() > 0) {
            u = userService.updateUser(user);
        }
        return ResultUtil.success(u);
    }

    /**
     * 根据账号密码获取用户信息
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/user")
    public Result<User> user(String username, String password) {
        if (username == null || password == null) {
            return ResultUtil.error(-1, "账号或者密码不能为空");
        }
        if ("".equals(username.trim()) || "".equals(password.trim())) {
            return ResultUtil.error(-1, "账号或者密码不能为空");
        }
        User user = userService.getUser(username, password);
        return ResultUtil.success(user);
    }

    /**
     * 根据token获取用户信息
     *
     * @param token
     * @return
     */
    @GetMapping("/user/token/{token}")
    public Result<User> getUser(@PathVariable("token") String token) {
        User user = userService.getUser(token);
        return ResultUtil.success(user);
    }

    /**
     * 根据用户id删除用户
     *
     * @param id
     * @return
     */
    @PostMapping("/user/{id}")
    public Result delUser(@PathVariable("id") Integer id) {
        User user = new User();
        user.setUserId(id);
        user.setStatus(-1);
        userService.updateUser(user);
        return ResultUtil.success();
    }

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public Result<User> getUser(@PathVariable("id") Integer id){
        User user = userService.getUser(id);
        return ResultUtil.success(user);
    }

}
