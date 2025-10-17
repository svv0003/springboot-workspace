package com.thejoeun.theMall.service;

import com.thejoeun.theMall.mapper.GoodsMapper;
import com.thejoeun.theMall.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> getAllGoods(){

        // 모든 사용자 조회
        // -> 관리자의 권한으로 접속한 것인가
        // -> 들어온 사람은 사용자 조회할 권리가 있는가
        // -> 데이터를 어떻게 보여줄 것인가
        // 예) 임직원 쇼핌몰

        return goodsMapper.getAllGoods();
    }


    /*
    void return 모두 가능하다.
    void 등록/실페 예외 발생해야 확인 가능하며,
    return는 성공시 1의 값을 반환하며, 0의 경우는 실패인 것으로
     성공 실패에 대한 결과 유무를 소비자에게 전달 가능하다.
     */
    public void insertGoods(Goods goods){
        goodsMapper.insertGoods(goods);
    }
}