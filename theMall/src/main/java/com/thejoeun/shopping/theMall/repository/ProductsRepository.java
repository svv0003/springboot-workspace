package com.thejoeun.shopping.theMall.repository;

import com.thejoeun.shopping.theMall.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

    // JPA 자바 개발자들과 유저들이 만들어 놓은 메서드 기능들 활용해서
    // select * from @Entity 설정된 객체 파일 모두 조회하는 등의 기능들 사용할 것이다.
    // 단순 기본 기능들은 모두 내장되어 있으므로 추가적으로 작성할 필요 없다.

}
