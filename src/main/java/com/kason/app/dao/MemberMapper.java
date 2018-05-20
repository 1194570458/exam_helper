package com.kason.app.dao;

import com.kason.app.entity.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    //根据手机号码查询用户
    Member selectByPhone(Integer phone);

    //根据账号密码查询用户

    Member selectByPhoneAndPassword(Member member);

    //根据手机号码和token查询用户

    Member selectByPhoneAndToken(Member member);
}