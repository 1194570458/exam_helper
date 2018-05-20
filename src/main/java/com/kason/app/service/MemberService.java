package com.kason.app.service;

import com.kason.app.entity.Member;

public interface MemberService {

    void Register(Member member);

    Member Login(Member member);

}
