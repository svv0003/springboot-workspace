package edu.thejoeun.myblog.service;

import edu.thejoeun.myblog.model.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

import java.util.List;

public interface MemberService {
    /**
     * 로그인을 위한 email 실행
     */

    /**
     * 모든 멤버 조회 로직을 완성하기
     * @return 반환 데이터는 멤버들의 목록 (=리스트)
     */
    List<Member> selectMemberList();

    /**
     * 로그인을 작업하기 위해 이메일과 비밀번호를 전달받고,
     * session은 null 데이터 허용 (DB 존재 X)
     * model은 null 데이터 허용 (DB 존재 X)
     * @param memberEmail
     * @param memberPassword
     * @param session
     * @param model
     * @return -> 로그인된 회원 정보를 반환한다.
     */
    String login(String memberEmail, String memberPassword, HttpSession session, Model model);

    /**
     * 관리자가 멤버 상세보기를 진행할 경우
     * 특정 멤버의 id 값을 이용해서 DB에서 멤버 정보를 가져온다.
     * @param memberId HTML에서 멤버 id를 클릭했을 때 id 값 가져오기
     * @return id 값으로 해당되는 데이터를 member 형태로 클라이언트에게 전달한다.
     */
    Member getMemberById(int memberId);

    /**
     * HTML -> JS -> Controller로 전달받은 회원의 모든 정보를
     * DB에 저장하고, 반환 값은 존재하지 않으며 전달 유무만 클라이언트가 확인한다.
     * @param member
     */
    void saveMember(Member member);
}