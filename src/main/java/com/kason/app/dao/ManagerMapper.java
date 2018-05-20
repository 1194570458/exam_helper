package com.kason.app.dao;

import com.kason.app.entity.Manager;

public interface ManagerMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    /**
     * 根据账号密码获取Manager信息
     */
    Manager selectOne(Manager manager);

}