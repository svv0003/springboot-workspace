package edu.the.joeun.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    /**
     * @param session   static으로 저장되어 있는 session에
     *                  로그인 정보가 존재하는지 가져오기
     * @return          만약에 loginUser에 존재하는 회원이 없다면
     *                  로그인 페이지로 이동하고,
     *                  현재 로그인된 상태에서 다시 login 페이지로 오려고 한다면
     *                  메인페이지로 돌려보내기
     */
    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        if (session.getAttribute("loginUser") != null) {
            return "redirect:/";
        }
        return "login";
    }
}
