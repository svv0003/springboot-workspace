package edu.thejoeun.goodscommunity.member.controller;

import edu.thejoeun.goodscommunity.board.model.service.BoardService;
import edu.thejoeun.goodscommunity.common.util.SessionUtil;
import edu.thejoeun.goodscommunity.member.model.dto.Member;
import edu.thejoeun.goodscommunity.member.model.service.MemberService;
import edu.thejoeun.goodscommunity.member.model.service.MemberServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

// @SessionAttributes({"loginUser"})
// SessionUtil, SessionAttributes 동시에 회원 정보가 저장되기 때문에 사용 안 한다.
@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class MemberAPIController {

    private final MemberServiceImpl memberService;


    // AI는 Model로 모든 것을 처리하려고 한다.
    // Model과 RedirectAttributes 구분해서 결과 값을 클라이언트에게 전달한다.
    @PostMapping("/login")
    public Map<String, Object> login(
    @RequestBody Map<String, String> loginData, HttpSession session) {

        String memberEmail = loginData.get("memberEmail");
        String memberPassword = loginData.get("memberPassword");

        Member member = memberService.login(memberEmail, memberPassword);

        Map<String, Object> res = memberService.loginProcess(memberEmail, memberPassword, session);

        return res;
    }

    @PostMapping("/logout")
    public Map<String, Object> logout(HttpSession session) {
        return memberService.logoutProcess(session);
    }

    /**
     * 로그인 상태 확인 API
     * React 앱이 시작될 때 호출된다.
     *
     * @param session
     * @return 로그인 상태를 반환한다.
     */
    @GetMapping("/check")
    public Map<String, Object> checkLoginStatus(HttpSession session) {
        return memberService.checkLoginStatus(session);
    }
}