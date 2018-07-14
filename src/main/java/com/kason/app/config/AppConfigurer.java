package com.kason.app.config;

import com.kason.app.interceptor.VertifyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfigurer implements WebMvcConfigurer {

    /**
     *  把Interceptor作为bean写入配置中
     *  Interceptor 添加注解Component
     *  解决Interceptor无法注入service
     */
    @Bean
    public VertifyInterceptor vertifyInterceptor(){
        return new VertifyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//            registry.addInterceptor(vertifyInterceptor())    //指定拦截器类
//                    .excludePathPatterns("/manager/login")
//                    .addPathPatterns("/**");              //指定拦截路径（所有路径）
    }
}
