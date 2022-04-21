package com.middleware.mobile.web;

import com.middleware.mobile.web.interceptor.OnlyPrivateInterceptor;
import com.middleware.mobile.web.interceptor.OnlyPublicInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OnlyPrivateInterceptor())
                .addPathPatterns(
                        "/board/add",
                        "/board/update/**",
                        "/board/delete/**",
                        "/comment/add/**",
                        "/comment/update/**",
                        "/comment/delete/**"
                        );

        registry.addInterceptor(new OnlyPublicInterceptor())
                .addPathPatterns("/login", "/join");
    }
}
