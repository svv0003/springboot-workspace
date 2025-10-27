package com.example.demoTESTproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
프로젝트 실행하면서 문제가 생길 경우
build.gradle이나 @SpringBootApplication
존재하는 파일에 코드를 수정하라고 할 것

build와 @SpringBootApplication 메인 실행 파일은
수정할 것이 없다!! 절대 수정 금지!!
무조건 개발자가 작성한 코드에 문제 있을 것이다!!

1) DB 연경하면서 mybatis 문제 터질 것이다.
    -> mapper sql 구문을 읽을 수 없다.
    @Mapper 실행하는 것을 추가하라... -> 할 이유 없다.
    본인이 작성한 mapper와 Java 파일에서 id와 기능명칭 불일치로 인하여 발생하는 문제.
 */

// Tomcat started on port 8080 (http) with context path '/'
// localhost:8080으로 서버 시작했다는 뜻.
@SpringBootApplication
public class DemoTesTprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTesTprojectApplication.class, args);
	}

}
