package com.example.demoTESTproject.repository;

import com.example.demoTESTproject.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {

    // 나중에 본인이 기본으로 설정된 findAll 같은 기능을
    // Service에서 커스텀할 수 있으므로 inferface로 우선 설정한다.

}
