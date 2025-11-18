package edu.thejoeun.goodscommunity.member.model.mapper;

import edu.thejoeun.goodscommunity.member.model.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    Member getMemberByEmail(String memberEmail);

    void saveMember(Member member);
    /*
    void saveMember(Member member);
    단순 저장한다.

    Member saveMember(Member member);
    데이터 저장 후 저장된 멤버 데이터 내용 조회한다.

    int saveMember(Member member);
    0,1을 기준으로 데이터 저장 성공 여부 반환하며,
    0,1 아닌 다른 수가 반환되면 그 수만큼 저장된 상태라는 뜻이다.
    주로 상품 여러 개 등록, 게시물 여러 개 등록한다.
     */
}