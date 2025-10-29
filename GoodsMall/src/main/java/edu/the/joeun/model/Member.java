package edu.the.joeun.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
    // 아래는 굳이 작성하지 않아도 되지만 게시물 수정, 가입일자를 관리자가 확인할 때 필요하다.
    private String created_at;
    private String updated_at;
}
