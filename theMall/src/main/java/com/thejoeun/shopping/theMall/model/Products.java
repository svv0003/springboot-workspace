package com.thejoeun.shopping.theMall.model;

// JPA의 경우, 개체명으로 repository service를 생성해야 개체간의 기능 연결이 원활하다.


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String product_id;
    @Column(nullable = false)
    private String product_name;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private int stock_quantity;
    @Column(nullable = false)
    private String supplier;
}
