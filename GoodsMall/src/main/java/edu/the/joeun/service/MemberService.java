package edu.the.joeun.service;

import edu.the.joeun.mapper.MemberMapper;
import edu.the.joeun.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;
    // private MemberMapper memberMapper = new MemberMapper();

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public void getAllMember() {
        memberMapper.getAllMember();
    }

    // 왜 void인가?
    // MemberMapper.java에서 void insertMember(Member member); 작성했기 때문이다.
    public void insertMember(Member member) {

        // 비밀번호 암호화
        // 1단계 : 회원이 HTML에 작성한 비밀번호를 가져와서 변수 공간에 담는다.
        String 유저작성패스워드 = member.getPassword();
        // 2단계 : 회원이 작성한 비밀번호를 암호화 처리해서 다른 변수 공간에 담는다.
        String 암호화된패스워드 = bCryptPasswordEncoder.encode(유저작성패스워드);
        // 3단계 : 암호화 처리된 비밀번호를 member 내부에 있는 password 변수에 담는다.
        member.setPassword(암호화된패스워드);

        // 위에서 작성한 코드 로직을 한 줄로 작성해도 상관없지만
        // 개발할 때 System.out.println()로 코드 로직을 개발자가
        // 원하는 형태로 진행되고 있는지 확인하기 위해 변수명에 나눠 담아서 작성한다.
        // member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));

        memberMapper.insertMember(member);
    }
}
