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
import javax.servlet.http.HttpSession;
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
        uriList.add("/kenowledgetype/getall");
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

        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){
            return false;
        }
        return true;
    }

}
