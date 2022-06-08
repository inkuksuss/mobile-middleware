package com.middleware.mobile.web;

import com.middleware.mobile.web.filter.CORSFilter;
import com.middleware.mobile.web.interceptor.OnlyPrivateInterceptor;
import com.middleware.mobile.web.interceptor.OnlyPublicInterceptor;
import com.middleware.mobile.web.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final MemberService memberService;

    @Bean
    public FilterRegistrationBean<CORSFilter> corsFilter() {
        FilterRegistrationBean<CORSFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new CORSFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setOrder(1);
        return filterFilterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OnlyPrivateInterceptor(memberService))
                .addPathPatterns(
                        "/board/add",
                        "/board/update/**",
                        "/board/delete/**",
                        "/comment/add/**",
                        "/comment/update/**",
                        "/comment/delete/**"
                        );

        registry.addInterceptor(new OnlyPublicInterceptor(memberService))
                .addPathPatterns("/login", "/join");
    }
}
