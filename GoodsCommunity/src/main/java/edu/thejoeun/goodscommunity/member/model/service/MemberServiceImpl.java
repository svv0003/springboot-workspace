package edu.thejoeun.goodscommunity.member.model.service;

import edu.thejoeun.goodscommunity.member.model.dto.Member;
import edu.thejoeun.goodscommunity.member.model.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    // 추후 config에서 BCrypto 관리할 것이며, @Autowired 사용할 것이다.

    /**
     * MemberService에 작성한 기능명칭 (매개변수 자료형 개수)가
     * MemberServiceImpl과 일치하지 않으면 @Override 된 상태가 아니다.
     * 명칭만 똑깥이 썼을 뿐
     *
     * @param memberEmail    HTML -> JS -> controller api/endpoint로 가져온 이메일
     * @param memberPassword HTML -> JS -> controller api/endpoint로 가져온 비밀번호
     *                       session              회원 정보가 DB에서 조회되면 session 부여한다.
     *                       model                회원 정보가 조회되면 model 세팅한다.
     * @return
     */
    @Override
    public Member login(String memberEmail, String memberPassword) {

        Member member = memberMapper.getMemberByEmail(memberEmail);

        // DB에서 email로 조회되는 것이 없는게 사실이라면 NULL
        if (member == null) {
            return null;
        }

        // 비밀번호 일치하지 않은게 사실이라면 NULL
        if (!bCryptPasswordEncoder.matches(member.getMemberPassword(), member.getMemberPassword())) {
            return null;
        }

        // 이메일이 존재하며, 비밀번호까지 일치한다면
        // 비밀번호를 제거한 상태로 회원정보를 controller에 전달한다.
        member.setMemberPassword(null);

        // 멤버에 대한 모든 정보를 controller에 전달한다.
        return member;
    }

}

