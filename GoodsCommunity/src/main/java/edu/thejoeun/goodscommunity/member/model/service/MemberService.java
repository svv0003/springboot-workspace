package edu.thejoeun.goodscommunity.member.model.service;

import edu.thejoeun.goodscommunity.member.model.dto.Member;
import org.springframework.stereotype.Service;

public interface MemberService {
    /**
     * 프로젝트에서 기능 명칭을 지정하는 공간
     */
    Member login(String memberEmail, String memberPassword);

}