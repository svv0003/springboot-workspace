package edu.the.joeun.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 일반 회원이 로그인할 때 접속할 수 있는 API 리스트
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns(       // 회원이 (특별히 더) 접속할 수 있는 API 주소들
                        "/goodsList",   // 상품 목록
                        "/goodsAdd"     // 상품 등록
                )
                .excludePathPatterns(   // 누구든지 들어갈 수 있는 API 주소들
                        "/",            // 메인페이지
                        "/login",       // 로그인페이지
                        "/logout",      // 로그아웃페이지
                        "/css/**",      // CSS 파일
                        "/js/**",       // JS 파일
                        "/images/**",   // Image 파일
                        "/api/**",      // API 요청
                        "/user/add"     // 회원 등록
                )
            ;

        // 관리자 회원이 로그인할 때 (특별히 더) 접속할 수 있는 API 리스트
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns(
                        "/user/list"    // 회원 목록은 관리자만 들어갈 수 있다.
                )
            ;
    }
}
