package com.kason.app.controller;


import com.kason.app.dao.MemberMapper;
import com.kason.app.entity.Member;
import com.kason.app.entity.Result;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.MemberService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RequestMapping("/member")
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public Result<Member> RegisterMember(@RequestBody Member member) {
        if (member.getExamTypeId() == null || member.getExamTypeId() == 0) {
            throw new AppException(ResultEnum.EXAM_ID_NULL);
        }
        memberService.Register(member);
        return ResultUtil.success();
    }


    @PostMapping("/login")
    public Result<Member> Login(@RequestBody Member member, HttpSession session) {
        if (member.getPhone() == null || member.getPhone() == 0) {
            throw new AppException(ResultEnum.MEMBER_PHONE_NULL);
        }
        if (member.getPassword() == null || "".equals(member.getPassword())) {
            throw new AppException(ResultEnum.MEMBER_PASSWORD_NULL);
        }
        member = memberService.Login(member);
        session.setAttribute("user", member);
        return ResultUtil.success(member);
    }


}
