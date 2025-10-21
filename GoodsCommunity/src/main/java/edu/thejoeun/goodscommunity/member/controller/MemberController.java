package edu.thejoeun.goodscommunity.member.controller;

import edu.thejoeun.goodscommunity.common.util.SessionUtil;
import edu.thejoeun.goodscommunity.member.model.dto.Member;
import edu.thejoeun.goodscommunity.member.model.service.MemberServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// @SessionAttributes({"loginUser"})
// SessionUtil, SessionAttributes 동시에 회원 정보가 저장되기 때문에 사용 안 한다.
@Controller
public class MemberController {

    @Autowired
    MemberServiceImpl memberService;

    @GetMapping("/")
    public String pageMain(){
        // return "main";
        return "index";
    }


    // 쿠키 설정할 때 아이디 저장 안 되면 가정 먼저하는 작업이다.
    // @CookieView와 Model은 필요 없다.
    @GetMapping("/login")
    public String pageLogin() {
        return "pages/login";
    }

    // AI는 Model로 모든 것을 처리하려고 한다.
    // Model과 RedirectAttributes 구분해서 결과 값을 클라이언트에게 전달한다.
    @PostMapping("/login")
    public String login(@RequestParam String memberEmail,
                        @RequestParam String memberPassword,
                        @RequestParam(required = false) String saveId, // 필수로 전달하지 않아도 되는 매개변수
                        HttpSession session,
                        HttpServletResponse res,
                        Model model,
                        RedirectAttributes ra){
        Member member = memberService.login(memberEmail, memberPassword);

        if(member == null){
            ra.addFlashAttribute("error", "이메일 또는 비밀번호가 일치하지 않습니다.");
            return "redirect:/login";
        }

        // 세션에 로그인 정보 저장하는 이 방법을 사용하게 되면 매번 로그인 정보를 코드마다 세팅해야 하기 때문에 사용 안 한다.
        // session.setAttribute("loginUser", member);
        model.addAttribute("loginUser", member);
        SessionUtil.setLoginUser(session, member);

        // 쿠키에 사용자 정보 저장 (보안상 민감하지 않은 부분만 저장한다.)
        Cookie userIdCookie = new Cookie("saveId", memberEmail);
        userIdCookie.setPath("/");

        /*
        체크박스에서 value가 없을 때
        - 체크된 경우 : on
        - 체크되지 않은 경우 : null
        아이디 저장과 같이 단순 체크는 on - null 이용해서 체크 유무 확인하고,
        아이디를 작성 안 했는데 쿠키에 저장할 이유가 없으므로 아이디 값을 작성하고,
        아이디 저장 체크를 했을 경우에만 30일 동안 아이디 명칭을 저장하겠다.
         */
        /*
        문자열1.equals(문자열2)
        String 내부에 작성되어 있는 메서드 .equals()는 맨 앞에 있는 문자열1이 문자열이면 일 때를 기준으로 만들어진 메서드

            문자열.equals(null)일 때는 내부 로직에 false를 반환하도록 되어 있다.
            -> 에러를 일으키지 않도록 되어 있다.

            saveId가 null 값으로 전달될 경우에는
            null.equals("문자열") 일 때는 대비해놓은 코드가 없다.

            saveId에 체크된 값으로 전달될 경우에는
            "on".equals("on") 형태로 전달되어 true 값을 반환하도록 기능 내부적으로 설정되어 있다.

        if (saveId.equals("on")){
        if ("on".equals(saveId)){
         */
        // userIdCookie != null &&
        if ("on".equals(saveId)){ // saveId라는 것이 html에 존재하지 않기 때문에 null 생성한다.  // 회원 아이디 저장 체그되어 있다면 30일간 회원 아이디를 저장하고, 안 되어 있으면 회원 아이디를 쿠키에 저장하지 않겠다.
            userIdCookie.setMaxAge(60*60*24*30);    // 60초 * 60분 * 24시간 * 30일을 초 단위로 지정한 것.
        } else {
            userIdCookie.setMaxAge(0);              // 클라이언트 쿠키 삭제하기.
        }

        res.addCookie(userIdCookie);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse res){
        SessionUtil.invalidateLoginUser(session);

        /*
        로그아웃 시 아이디가 저장되어 있는 saveId도 삭제된다.

        Cookie userIdCookie = new Cookie("saveId", null);
        userIdCookie.setMaxAge(0);
        userIdCookie.setPath("/");
        res.addCookie(userIdCookie);
         */

        return "redirect:/"; //로그아웃 선택시 모든 쿠키 데이터 지우고 메인으로 돌려보내기
    }
}
