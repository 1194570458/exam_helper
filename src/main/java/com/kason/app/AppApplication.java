package com.kason.app;

import com.kason.app.interceptor.VertifyInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("com.kason.app.dao")
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    //mvc控制器
    @Configuration
    static class AppMvcConfigurer implements WebMvcConfigurer {

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
            registry.addInterceptor(vertifyInterceptor())    //指定拦截器类
                    .addPathPatterns("/**");              //指定拦截路径（所有路径）
        }
    }

}
