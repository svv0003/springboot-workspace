package edu.the.joeun.controller;

import edu.the.joeun.model.Member;
import edu.the.joeun.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberAPIController {

    @Autowired
    private MemberService memberService;
    // postMapping 데이터 저장 시작

    /**
     * const response = await fetch('/api/member/add', {<br/>
     *      method: 'POST',<br/>
     *      headers: {<br/>
     *           'Content-Type': 'application/json',<br/>
     *      },<br/>
     *      body: JSON.stringify(memberData),<br/>
     *            // JSON 형태의 데이터를 문자열로 변환하여 Java로 전송한다.<br/>
     * });<br/>
     * 클라이언트가 데이터 저장 요청을 하러<br/>
     * /api/member/add 주소로 들어오면<br/>
     * JS로 들고온 문자열 형태 Key-Value 데이터를<br/>
     * Java 모델에 맞는 클래스 변수명에 각 K:V를 객체 형태로 대입한다.<br/>
     *
     * @param member JS에서 가져온 문자열 데이터를<br/>
     * @RequestBody 를 이용해서 Member에 맞는 객체 형태로 변환하여 값을 대입한다.<br/>
     *
     * 저장된 데이터를 기반으로 service 기능 시작 후<br/>
     * service 기능에 대한 결과 유무를 클라이언트한테 전달한다.<br/>
     */
    @PostMapping("/api/member/add")
    public void addMember(@RequestBody Member member){
        memberService.insertMember(member);
    }
}
