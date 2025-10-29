package edu.the.joeun.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
// @Entity
// JPA가 아니기 때문에 사용하지 않는다.
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // @Column(length = 100)
    // JPA가 아니기 때문에 사용하지 않는다.
    private String name;
    private String category;
    private int price;
    private int stock;

}
