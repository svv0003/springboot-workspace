package com.example.demoTESTproject.service;

import com.example.demoTESTproject.model.Goods;
import com.example.demoTESTproject.model.Products;
import com.example.demoTESTproject.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    // findAll 의 경우
    // 전체 상품 가져오기라는 기능이 내장되어 있기 때문에 List 목록 형태로 Goods 상품들을 가져와야 한다.

    public List<Goods> findAll() {
        return goodsRepository.findAll();

        // 외부에서 GoodsService 파일 내부에 작성된 findAll() 이라는 메서드 (=기능)을 사용하겠다 하면
        // SQL에서 Goods 테이블에 존재하는 Goods 상품 리스트 데이터를 전달해서 사용할 수 있도록 전달하겠다. return 설정.
    }

}
