package edu.thejoeun.goodscommunity.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*
Spring Boot에서 단독으로 실행한다.
회원가입 / 비밀번호 찾기 / 아이디 찾기 기능이 구현되지 않은 상태에서
로그인을 진행할 때 비밀번호가 기억나지 않을 경우 실행한다.
현재 프로젝트와 별개로 실행한다.
 */
public class PassEncoderUtil {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        // 암호화할 비밀번호 작성한다.
        String password = "abc1234";

        // BCrypt 암호화한다.
        String encodedPassword = bCryptPasswordEncoder.encode(password);

        System.out.println("=".repeat(10) + "BCrypt 비밀번호 생성" + "=".repeat(10));
        System.out.println("password : " + password);
        System.out.println("encodedPassword : " + encodedPassword);

        // 검증 테스트
        boolean matches = bCryptPasswordEncoder.matches(password, encodedPassword);
        System.out.println("검증 결과 : " + matches);

        // SQL UPDATE문 생성
        System.out.println("=====SQL UPDATE문 이용하여 비밀번호 변경하기=====");
        System.out.println("UPDATE tableName");
        System.out.println("SET");
        System.out.println("password_column = " + encodedPassword + ",");
        System.out.println("username_column = update your name");
        System.out.println("WHERE who is column = '   ';");

        // SQL INSERT문 생성
        System.out.println("=====SQL INSERT문 이용하여 비밀번호 변경하기=====");
        System.out.println("INSERT INTO tableName(password_column, column2, column3, ...");
        System.out.println("VALUES (" + encodedPassword + ", val2, val3)");
    }
}
