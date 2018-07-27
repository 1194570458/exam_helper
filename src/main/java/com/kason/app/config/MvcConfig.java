package com.kason.app.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/certificate_management").setViewName("/certificate_management");
        registry.addViewController("/user_management").setViewName("/user_management");
        registry.addViewController("/property_management").setViewName("/property_management");
        registry.addViewController("/synthesize_management").setViewName("/synthesize_management");
        registry.addViewController("/thesis_management").setViewName("/thesis_management");
        registry.addViewController("/case_management").setViewName("/case_management");






        registry.addViewController("/index_home").setViewName("/index_home");
        registry.addViewController("/user_user").setViewName("/user_user");
        registry.addViewController("/user_score").setViewName("/user_score");
        registry.addViewController("/user_certificate").setViewName("/user_certificate");
        registry.addViewController("/knowledge_type").setViewName("/knowledge_type");
        registry.addViewController("/knowledge_paper").setViewName("/knowledge_paper");
        registry.addViewController("/knowledge_chapter").setViewName("/knowledge_chapter");
        registry.addViewController("/certificate_type").setViewName("/certificate_type");

        super.addViewControllers(registry);
    }
}
