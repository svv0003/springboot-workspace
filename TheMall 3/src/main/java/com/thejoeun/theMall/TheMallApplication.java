/*
Spring Boot 프로젝트의 진입점 (Entry Point) 역할을 하는 클래스.
Spring Boot 어플리케이션을 시작하는 필수적인 코드이며, 프로젝트의 핵심 실행 파일.
프로그램을 실행할 때 가장 먼저 호출되는 코드이며, Spring Boot의 모든 설정과 기능을 초기화한다.
-> Spring Boot 어플리케이션 환경을 설정하고 실행한다.
-> 프로젝트의 컴포넌트 (Controller, Service, Mapper 등)를 자동으로 슼내하고 초기화한다.
-> 내장 서버 (예: Tomcat)를 시작해서 웹 어플리케이션을 실행 가능하게 한다.
 */

package com.thejoeun.theMall;
// 클래스가 속한 패키지를 정의한다.

import org.springframework.boot.SpringApplication;
// Spring Boot 어플리케이션을 실행하는 핵심 클래스
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Spring Boot 주요 기능을 활성화하는 어노테이션

@SpringBootApplication
/*
Spring Boot 주요 기능을 활성화하는 어노테이션
@EnableAutoConfiguration    Spring Boot 자동 설정 활성화 (DB 설정, 웹 서버 설정 자동 처리)
@ComponentScan              현재 패키지와 하위 패키지의 컴포넌트 (Controller, Service 등)를 자동 스캔하여 등록
@Configuration              이 클래스가 Spring의 설정 클래스임을 나타낸다.
 */
public class TheMallApplication {
// 어플리케이션의 메인 클래스
// 클래스명은 프로젝트를 대표하는 이름으로, 관례적으로 Application으로 끝낸다.
	public static void main(String[] args) {
    // 메인 메서드는 Java 프로그램의 진입점이며, 메서드가 실행되면 어플리케이션이 시작된다.
		SpringApplication.run(TheMallApplication.class, args);
        //                    Spring Boot가 이 클래스를 기준으로 설정과 컴포넌트를 로드한다.
        //                                              명령줄 인수로, 외부에서 실행 시 추가 설정을 전달할 수 있다.
	}
}
/*
Spring Boot 초기화
@SpringBootApplication이 자동 설정을 활성화하여 application.properties의 설정 (서버 포트, DB, Thymeleaf 등)을 로드한다.

컴포넌트 스캔
Com.thejoeun.theMall 패키지 아래의 모든 클래스 (Controller, Service 등)를 찾아 등록한다.

내장 서버 시작
내장된 Tomcat 서버를 포트 8080에서 시작하여 웹 어플리케이션을 실행한다.

의존성 통합
build.gradle에 정의된 의존성 (JPA, MyBatis, Thymeleaf)를 기반으로 필요한 라이브러리를 로드한다.
 */