package com.kason.app.service.impl;

import com.kason.app.dao.CertificateMapper;
import com.kason.app.dao.UserMapper;
import com.kason.app.entity.User;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.UserService;
import com.kason.app.utils.SHAUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CertificateMapper certificateMapper;

    private boolean hasCertificate(Integer cerId) {
        if (certificateMapper.selectByPrimaryKey(cerId) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public User addUser(User user) {
        if (!hasCertificate(user.getCerId())) {
            throw new AppException(ResultEnum.CERTIFICATE_NOT_EXIST);
        }
        if (userMapper.selectByUserName(user.getUsername()) != null) {
            throw new AppException(ResultEnum.USER_EXIST);
        }
        user.setStatus(1);
        user.setRole(0);
        user.setCreateDate(new Date());
        user.setPassword(SHAUtils.getSHA256StrJava(user.getPassword()));
        userMapper.insertSelective(user);
        user.setPassword(null);
        return user;
    }

    @Override
    public User getUser(String username, String password) {
        password = SHAUtils.getSHA256StrJava(password);
        User user = userMapper.selectByUsernameAndPassowrd(username, password);
        if (user == null) throw new AppException(ResultEnum.USER_ERROR);
        //生成token
        String token = SHAUtils.getSHA256StrJava(username + password + System.currentTimeMillis());
        user.setToken(token);
        userMapper.updateByPrimaryKeySelective(user);
        user.setPassword(null);
        return user;
    }

    @Override
    public User getUser(String token) {
        User user = userMapper.selectByToken(token);
        if (user == null) {
            throw new AppException(ResultEnum.USER_TOKEN_ERROR);
        }
        user.setPassword(null);
        return user;
    }

    @Override
    public User updateUser(User user) {
        if (user.getPassword()!=null) {
            user.setPassword(SHAUtils.getSHA256StrJava(user.getPassword()));
            user.setToken("");
        }
        if (user.getCerId() != null)
            if (!hasCertificate(user.getCerId())) {
                throw new AppException(ResultEnum.CERTIFICATE_NOT_EXIST);
            }
        if (userMapper.selectByUserName(user.getUsername()) != null) {
            throw new AppException(ResultEnum.USER_EXIST);
        }
        user.setCreateDate(null);
        userMapper.updateByPrimaryKeySelective(user);
        User u = userMapper.selectByPrimaryKey(user.getUserId());
        u.setPassword(null);
        return u;
    }

    @Override
    public User getUser(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) throw new AppException(ResultEnum.USER_NOT_EXIST);
        user.setPassword(null);
        return user;
    }
}
