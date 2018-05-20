package com.kason.app.service.impl;

import com.kason.app.dao.ExamTypeMapper;
import com.kason.app.dao.MemberMapper;
import com.kason.app.entity.ExamType;
import com.kason.app.entity.Member;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.MemberService;
import com.kason.app.utils.SHAUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private ExamTypeMapper examTypeMapper;

    /**
     * 注册一个用户
     *
     * @param member
     */
    @Override
    public void Register(Member member) {
        if (memberMapper.selectByPhone(member.getPhone()) != null) { //判断是否已经注册
            throw new AppException(ResultEnum.MEMBER_PHONE_EXIST);
        }
        if (examTypeMapper.selectByPrimaryKey(member.getExamTypeId()) == null) {  //判断是否已经有软考类型
            throw new AppException(ResultEnum.EXAM_NULL);
        }
        memberMapper.insertSelective(member);
    }

    /**
     * 用户登陆
     *
     * @param member
     * @return 登陆成功后返回该用户信息
     */
    @Override
    public Member Login(Member member) {
        member = memberMapper.selectByPhoneAndPassword(member); //验证证明密码是否正确
        if (member == null)
            throw new AppException(ResultEnum.MEMBER_ERROR);
        long radomPhone = member.getPhone() + System.currentTimeMillis();
        String sha256Str = SHAUtils.getSHA256StrJava(radomPhone + member.getPassword());
        member.setToken(sha256Str);
        memberMapper.updateByPrimaryKeySelective(member);
        member.setPassword("");
        member.setRegDate(null);
        member.setWecharOpenid(null);
        member.setQq(null);
        member.setQqOpenid(null);
        return member;
    }
}
