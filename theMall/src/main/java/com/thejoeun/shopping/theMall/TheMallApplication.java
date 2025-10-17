package com.thejoeun.shopping.theMall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// JDBC
// Java와 DB 연결하여 자바에서 DB 조회/삽입/수정/삭제과 같은 SQL 구문 작성을 위해
// SpringBoot 내부에 @SpringBootApplication 명칭으로 만든 기능.
// SpringBootApplication.java 파일 존재.
// -> 이 파일을 @SpringBootApplication로 읽겠다고 설정.
// @자바파일명 으로 가져오는 방식은 추후 배울 것이당.

// Servlet
// Java와 HTML을 연결하는 기능.
// Java 자체에서 HTML 코드를 작성할 수 있으나,
// HTML 코드를 따로 분리해서 데이터를 전달하고 저장하는 MVC 패턴 방식이 개발하는데 있어
// 개발자들 간의 문제가 덜 생기도록 제안하는 패턴을 따라 Java와 HTML 간의 요청 연결 설정이
// Spring Boot 내부에 @SpringBootApplication 명칭으로 저장.
@SpringBootApplication
public class TheMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheMallApplication.class, args);
	}

}
