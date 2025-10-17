package thejoeun.shopping.TheMall.model;

// JPA의 경우에는 jakarta 폴더에 작성되어 있다.
// jakarta가 아닌 다른 폴더에 Id나 GeneratedValue Entity 등 존재하는 건 하위 버전 코드.
// -> javax 등을 추천하는 AI는 예전 정보를 알려준 것이다.
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity     // JPA 방식은 Entity 사용하지만 mybatis 형식은 사용 X
public class Goods {

    // AI는 Long 형태로 id 작성하라고 하지만 우리는 int 형태로 맞추면서 long 진행할 것이다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,  unique = true)   // mybatis는 컬럼 제약 조건 설정하지 않는다.
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int stock;

}
