package com.kason.app.interceptor;

import com.kason.app.dao.MemberMapper;
import com.kason.app.entity.Manager;
import com.kason.app.entity.Member;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 账号密码验证拦截器
 */
@Component
public class VertifyInterceptor implements HandlerInterceptor {

    private final static Logger log = LoggerFactory.getLogger(VertifyInterceptor.class);

    @Autowired
    private ManagerService managerService;
    @Autowired
    private MemberMapper memberMapper;

    private static List<String> uriList = null;

    static {
        uriList = new ArrayList<>();
        uriList.add("/manager/login");
        uriList.add("/certificate/getall");
        uriList.add("/examtype/getall");
        uriList.add("/member/login");
    }

    private class HandleManager {
        String username;
        String password;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("utf-8");

        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
        //设置自定义请求头
        response.addHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type,username,password");

        //跨域设置自定义头 首次options要跳过
        if(request.getMethod().contains("OPTIONS")) {
            response.setStatus(202);
            return false;
        }

        //对特定请求不拦截
        String uri = request.getRequestURI();
        for (String list : uriList) {
            if (uri.equals(list)) return true;
        }


        if (request.getParameter("token") == null || "".equals(request.getParameter("token"))) {
            String username = request.getHeader("username");
            String password = request.getHeader("password");
            if (username == null || "".equals(username.trim())) {
                log.error(" Verify Error.Result={}", "账号验证过期或者失败，请重新登陆.username=null");
                throw new AppException(ResultEnum.VERTIFY_ERROR);
            }
            if (password == null || "".equals(password.trim())) {
                log.error(" Verify Error.Result={}", "账号验证过期或者失败，请重新登陆.password=null");
                throw new AppException(ResultEnum.VERTIFY_ERROR);
            }
            return UPInterceptor(username, password);
        } else {
            try {
                return TokenInterceptor(Integer.parseInt(request.getParameter("phone")), request.getParameter("token"));
            } catch (NumberFormatException e) {
                throw new AppException(ResultEnum.PHONE_ERROR);
            }
        }
    }

    private boolean UPInterceptor(String username, String password) {
        Manager manager = new Manager();
        manager.setUsername(username);
        manager.setPassword(password);
        if (managerService.getManager(manager) == null) {
            log.error(" Verify Error.Result={}", "账号验证过期或者失败，请重新登陆.username,password error");
            throw new AppException(ResultEnum.VERTIFY_ERROR);
        }
        return true;
    }

    private boolean TokenInterceptor(Integer phone, String token) {
        Member member = new Member();
        member.setPhone(phone);
        member.setToken(token);
        if (memberMapper.selectByPhoneAndPassword(member) == null) {
            log.error(" Verify Error.Result={}", "账号验证过期或者失败，请重新登陆.");
            throw new AppException(ResultEnum.MEMBER_ERROR);
        }
        return true;
    }
}
