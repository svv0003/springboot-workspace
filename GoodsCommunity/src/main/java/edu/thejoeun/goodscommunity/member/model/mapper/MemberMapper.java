package edu.thejoeun.goodscommunity.member.model.mapper;

import edu.thejoeun.goodscommunity.member.model.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    Member getMemberByEmail(String memberEmail);
}