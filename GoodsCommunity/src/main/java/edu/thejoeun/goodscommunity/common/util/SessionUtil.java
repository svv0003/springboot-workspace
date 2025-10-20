package edu.thejoeun.goodscommunity.common.util;

import edu.thejoeun.goodscommunity.member.model.dto.Member;
import jakarta.servlet.http.HttpSession;

public class SessionUtil {

    private static final String LOGIN_USER = "loginUser";

    public static void setLoginUser (HttpSession session, Member member) {
        session.setAttribute (LOGIN_USER, member);
        session.setMaxInactiveInterval(30*60);
    }

    public static void invalidateLoginUser (HttpSession session) {
        session.removeAttribute (LOGIN_USER);
        // 모든 세션을 지우는 것이 아니라 해당 세션만 지워서 로그아웃 처리한다.
    }
}
