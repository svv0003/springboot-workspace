package com.example.demoTESTproject.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity     // =SQL 테이블 객체
public class Products {

    // SQL PRIMARY KEY를 나타내는 어노테이션. 어노테이션 내부에 Column 컬럼 존재한다.
    @Id
    // AUTO_INCREMENT 번호 자동 생성하는 어노테이션.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    // 중복 불가 (소괄호 내부에 제약 조건 설정 가능하다.)
    @Column(nullable = false)
    private String product_name;    // SQL에 작성한 컬럼명과 변수명이 다를 경우, name="컬럼명" 옵션 추가 가능하다.
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private int stock_quantity;
    @Column(nullable = false)
    private String supplier;

}
