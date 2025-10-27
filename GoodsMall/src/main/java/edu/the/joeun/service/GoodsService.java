package edu.the.joeun.service;

import edu.the.joeun.mapper.GoodsMapper;
import edu.the.joeun.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
@Mapper에서 xml에 작성한 SQL 구문을 id 값으로 보유한다.
보유한 SQL 구문을 각 기능에 맞게 호출하여 사용한다.
SQL에 데이터를 저장, 조회, 수정, 삭제와 같은
전반적인 모든 기능을 담당하는 공간이다.
mapper, contoller, service 중 코드가 가장 긴 공간이다.
@Service에서 전반적인 기능 로직 작성한다.
 */

@Service
public class GoodsService {

    // new 생성자로 사용할 객체 인스턴스 생성을 대신 해주는 어노테이션
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 모든 상품 정보를 조회하기.
     *
     * @return SQL에서 가져온 상품 목록 (List<Goods>)를 반환하여
     *         controller /api/endpoint 주소에서 반환된 상품 목록 조회 가능하다.
     */
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    /**
     * 전달받은 상품 정보를 DB에 저장하기.
     *
     * @param goods 저장할 상품 정보 (Goods 객체)
     * @param = 파라미터 = 매개변수로 Controller에서 전달받은 데이터를 담고 있는 변수명 설정
     *
     * void insertGoods(Goods goods)
     * void insertGoods(int id, String name, int price, int stock)
     *                  상품번호, 상품명, 가격, 수량을 하나하나 전달받을 수 있지만
     *                  번거롭기 때문에 Goods goods 명칭으로 사용한다.
     */
    public void insertGoods(Goods goods) {
        goodsMapper.insertGoods(goods);
    }
}
