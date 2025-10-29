package edu.the.joeun.mapper;

import edu.the.joeun.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    // MyBatis xml에서 작성한 SQLㅇ르 가져올 id와 기능명을 작성한다.
    // resources/mappers/MemberMapper.xml 파일에서 id 값이
    // insertMember인 SQL 구문을 가져와 보유하고 있는 형태를 띄울 것.

    List<Member> getAllMember();

    void insertMember(Member member);
}



