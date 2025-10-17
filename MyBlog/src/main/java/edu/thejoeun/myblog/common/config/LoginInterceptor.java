package edu.thejoeun.myblog.common.config;

import edu.thejoeun.myblog.model.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// 아무 클래스에서나 작성 가능하고, 역할이 불명확한 형태의 설정이다.
// Spring Boot에서 알아서 관리하라는 설정이다.
// 기능 클래스, 도메인 구성 요소에 주로 사용하는 어노테이션이다.
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 특정 멤버의 세션을 저장하는 명칭을 설정하여 회원 세션 데이터를 조회하도록 설정한다.
        HttpSession session = request.getSession();

        Member loginUser = (Member) session.getAttribute("loginUser");
        // 로그인 안 됐을 경우
        if (loginUser == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
