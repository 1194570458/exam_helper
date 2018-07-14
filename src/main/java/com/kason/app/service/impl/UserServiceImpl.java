package com.kason.app.service.impl;

import com.kason.app.dao.UserMapper;
import com.kason.app.entity.User;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.UserService;
import com.kason.app.utils.SHAUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(User user) {
        if (userMapper.selectByUserName(user.getUsername())!=null) {
            throw new AppException(ResultEnum.USER_EXIST);
        }
        userMapper.insertSelective(user);
        return user;
    }

    @Override
    public User getUser(String username, String password) {
        User user = userMapper.selectByUsernameAndPassowrd(username,password);
        if(user==null)throw new AppException(ResultEnum.USER_ERROR);
        //生成token
        String token = SHAUtils.getSHA256StrJava(username + password + System.currentTimeMillis());
        user.setToken(token);
        updateUser(user);
        return user;
    }

    @Override
    public User getUser(String token) {
        User user= userMapper.selectByToken(token);
        if(user==null){
            throw new AppException(ResultEnum.USER_TOKEN_ERROR);
        }
        return user;
    }

    @Override
    public User updateUser(User user) {
        if (userMapper.selectByUserName(user.getUsername())!=null) {
            throw new AppException(ResultEnum.USER_EXIST);
        }
        userMapper.updateByPrimaryKeySelective(user);
        User u =userMapper.selectByPrimaryKey(user.getUserId());
        return u;
    }
}
