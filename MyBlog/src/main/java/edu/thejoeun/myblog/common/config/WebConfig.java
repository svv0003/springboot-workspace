package edu.thejoeun.myblog.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 환경설정이라는 어노테이션이다.
// Spring Boot가 처음 시작할 때 @Configuration으로 작성되어 있는 환경설정을 가장 먼저 프로젝트에서 세팅한다.
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 회원 인터셉터, 관리자 인터셉터로 구분지어서
    // 로그인한 회원이 들어갈 수 있는 URL,
    // 관리자 회원이 들어갈 수 있는 URL,
    // 비로그인 회원이 들어갈 수 있는 URL 설정하기.



    // webconfig 설정에 대해 권장할 때 --->>> HELP 요청하기


    // template

    // 설정을 마치면 Controller에서 @CrossOrigin("*")과 같은 설정이 필요 없다.
    // 나중에 추가적으로 filterChain 메서드를 추가할 것이다.

    // 리액트와 작업할 때 리액트 서버/포트 관련 추가 설정 필요하다.
    // 지금은 Spring Boot 자체에서 HTML 또는 JSP 실행할 것이기 때문에 현재 필요하지 않다.

    // HTML 파일을 클릭해서 생성된 URL (파일 경로)와 localhost:8080/ URL과 다르다.
    // localhost:8080/ URL는 프론트엔드, 백엔드가 자유로운 내 가두리 안에서의 작업이지만
    // 파일 경로 URL는 백엔드 작업이 아닌 그저 화면 렌더링이다?
}
