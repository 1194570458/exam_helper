package com.kason.app.service.impl;

import com.kason.app.dao.ManagerMapper;
import com.kason.app.entity.ExamType;
import com.kason.app.entity.Manager;
import com.kason.app.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 管理员登陆
     * @param manager
     * @return  成功则返回manager对象，失败返回null
     */
    @Override
    public Manager getManager(Manager manager) {
        manager = managerMapper.selectOne(manager);
        return manager;
    }


}
