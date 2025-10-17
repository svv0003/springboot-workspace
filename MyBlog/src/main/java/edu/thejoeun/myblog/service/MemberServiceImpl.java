package edu.thejoeun.myblog.service;

import edu.thejoeun.myblog.mapper.MemberMapper;
import edu.thejoeun.myblog.model.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Transactional
/*
해당 클래스 종료 시까지 예외 발생 안하면 commit
발생하면 rollback
 */
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<Member> selectMemberList() {
        // 회원 리스트 조회
        return memberMapper.selectMemberList();
    }

    @Override
    public String login(String memberEmail, String memberPassword, HttpSession session, Model model) {
        Member member = memberMapper.getMemberByEmail(memberEmail);

        if (member==null){
            model.addAttribute("error", "not found email");
            return "login";
        }

        member.setMemberPassword(null);
        // sessionUtil
        return "redirect:/";
    }

    public void logout(HttpSession session){
        // 로그아웃 세션 추가
    }

    @Override
    public Member getMemberById(int memberId) {
        return memberMapper.getMemberById(memberId);
    }

    @Override
    public void saveMember(Member member) {

        // 비밀번호 암호화 저장하기
        // HTML -> controller로 가져온 데이터 중에서 비밀번호만 따로 가져와서
        // 암호화 처리한 뒤 다시 비밀번호 공간에 넣는다.
        String a = member.getMemberPassword();
        member.setMemberPassword(bCryptPasswordEncoder.encode(a));


        memberMapper.saveMember(member);
    }

}
