package edu.thejoeun.goodscommunity.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
프론트엔드와 백엔드를 나누어 작업할 때 사용한다.
corsConfigurer 설정은 WebConfig 명칭을 사용하거나
CorsConfig 명칭을 사용하기도 하며, 회사 지정 명명규칙을 따라 작성한다.
 */
@Configuration
public class WebConfig {

    /*

     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {                      // 특정 주소와 메서드만 스프링부트에 접근 가능하도록 설정한다.
        return new WebMvcConfigurer() {                             // new WebConfigurer 객체 사용 후 return을 한 번에 작성하는 방식이다.
            @Override
            public void addCorsMappings(CorsRegistry registry) {    // CORS 매칭 추가하는 기능이다.
                registry.addMapping("/api/**")           // /api/로 시작하는 모든 하위 경로에 대해 접근을 허용한다.
                        .allowedOrigins("http://localhost:3000")    // 요청을 허용할 출처를 지정한다.
                        .allowCredentials(true)                     // 쿠키, HTTP 인증을 포함한 요청을
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // 허용할 HTTP
                        .allowedHeaders("*");                       // 허용할 HTTP 요청 헤더이다.
            }
        };
    }
}
/*
이 코드는 스프링 부트(Spring Boot)에서 CORS (Cross-Origin Resource Sharing, 교차 출처 리소스 공유) 설정을 하는 파일이다.

왜 필요한가?
웹 브라우저는 기본적으로 **'동일 출처 정책'(Same-Origin Policy)**이라는 보안 규칙을 따른다.
이 규칙 때문에, 예를 들어 http://localhost:3000 (리액트 같은 프론트엔드)에서 실행되는 웹페이지가
http://localhost:8080 (스프링 부트 같은 백엔드)처럼 서로 다른 '출처'(주소)로
API 요청(Ajax, fetch 등)을 보내면 브라우저가 이 요청을 차단한다.
"출처가 다르니 위험할 수 있다"고 판단하는 것이다.

이 코드는 무엇을 하나?
이 WebConfig 코드는 CORS 설정을 통해 백엔드 서버가 브라우저에게
"이봐, 브라우저! 특정 출처에서 오는 요청은 안전하니까 허용해 줘!"라고 알려주는 역할을 한다.

즉, '동일 출처 정책'의 예외를 설정하여 프론트엔드와 백엔드가 원활하게 통신할 수 있게 해준다.

@Configuration                              스프링에게 이 클래스가 설정 파일임을 알립니다.
@Bean                                       이 메서드가 반환하는 객체(WebMvcConfigurer)를 스프링이 관리하도록 등록합니다.
addCorsMappings(CorsRegistry registry)      CORS 설정을 추가하는 부분입니다.
registry.addMapping("/api/**")              /api/로 시작하는 모든 주소에 대해 이 CORS 정책을 적용합니다. (/api/가 아닌 다른 주소(예: /)에는 적용되지 않습니다.)
.allowedOrigins("http://localhost:3000")    가장 중요한 부분입니다. http://localhost:3000 (보통 리액트 개발 서버)에서 오는 요청만 허용합니다.
.allowedMethods(...)                        "GET", "POST", "PUT", "DELETE" 등 허용할 HTTP 요청 방식(메서드)을 지정합니다.
.allowCredentials(true)                     요청 시 쿠키나 인증 정보(Authorization 헤더 등)를 함께 보낼 수 있도록 허용합니다.
.allowedHeaders("*")                        모든 HTTP 헤더를 허용합니다.
 */