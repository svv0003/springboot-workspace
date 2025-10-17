package edu.thejoeun.myblog.controller;

import edu.thejoeun.myblog.model.Member;
import edu.thejoeun.myblog.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 백엔드가 프론트엔드로 데이터를 제대로 보내는지 확인하는 컨트롤러
// 프론트엔드 요청사항을 전달하는 컨트롤러
@RestController
public class MemberAPIController {

    @Autowired
    private MemberServiceImpl memberService;

    // 백엔드에서 데이터가 바로 HTML 파일로 전송한다.
    @GetMapping("/api/memberList")
    public List<Member> getMemberList(){
        return memberService.selectMemberList();
    }

    /**
     * Model model => login에서만 사용하고, 다른곳에서는 사용하지 않는다.
     * myPage로 member 명칭을 활용해서 백엔드 확인 없이 프론트엔드로 바로 데이터 전송하는 방법이다.
     * 실무 3년 이하 추천하지 않으며, 고전 방식이라 현업에서 많이 사용 안 한다.
     *
     *
     *     @GetMapping("/api/member/{id}")
     *     public String getMemberById(@PathVariable int id, Model model) {
     *         Member member = memberService.getMemberById(id);
     *         model.addAttribute("member", member);
     *         return "myPage";
     *     }
     */
    /**
     * 백엔드에서 데이터를 제대로 조회하고 있는지 확인하는 로직
     * 리액트-뷰-앵귤러-JS 소통에서도 모두 이 방식을 활용한다.
     * @param id @PathVariable 주소창에 값으로 넣을 변수명이나 데이터
     * @return SELECT * FROM 테이블명 WHERE id = #{id}
     *         id 값으로 DB에서 조회된 데이터를 백엔드로 전달한다.
     *
     * http://localhost:8080/api/member/1
     *
     * 관리자가 모든 유저 리스트에서 유저 한명을 선택하여 상세보기로 이동할 때 사용한다.
     */
    @GetMapping("/api/member/{id}")
    public Member getMemberById(@PathVariable int id ){
        return memberService.getMemberById(id);
    }

    /**
     * 마이페이지에서 본인의 정보를 조회할 때 사용한다.
     * 추가적으로 session 정보와 session 정보를 전달할 Model model을 활용하여 전송할 예정이다.
     * @param id
     * @return
     */
    @GetMapping("/api/mypage")
    public Member getMemberByMyPage(int id){
        return memberService.getMemberById(id);
    }

    @PostMapping("/api/member/register")
    public void saveMember(@ModelAttribute Member member){
        memberService.saveMember(member);
    }
}
