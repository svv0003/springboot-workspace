package edu.thejoeun.myblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private int memberId;
    private String memberName;
    private String memberEmail;
    private String memberPassword;
    private String memberRole;
    private String memberCreateAt;
    private String memberUpdateAt;

}
