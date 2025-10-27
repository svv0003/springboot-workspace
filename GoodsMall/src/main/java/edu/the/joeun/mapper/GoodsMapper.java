package edu.the.joeun.mapper;

import edu.the.joeun.model.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
Mapper의 경우에는 resource/mappers/ 폴더 아래에
각 회사 개발자들이 작성한 SQL을 기반으로 움직일 명칭들을 작성한다.

mapper.xml 파일에서 id로 작성한 명칭과
class Mapper.java에서 작성한 기능 명칭이
일치해야 xml 파일에서 작성한 SQL 구문이 동작한다.
 */

@Mapper
public interface GoodsMapper {

    /*
    <select id="getAllGoods" resultMap="goodsMap">
        SELECT * FROM Goods ORDER BY id DESC
    </select>

    <select id="getGoodsById" parameterType="int" resultMap="goodsMap">
        SELECT * FROM Goods WHERE = #{id}
    </select>

    <insert id="insertGoods" parameterType="edu.the.joeun.model.Goods">
        INSERT INTO Goods (name, price, stock) VALUES (#{name}, #{price}, #{stock})
    </insert>
     */

    // 모든 상품들 조회하기
    // List<객체 타입 문서명 설정>
    List<Goods> getAllGoods();

    // 상품 등록하기
    // 매개변수로 저장할 데이터가 담긴 변수명을 한 번에 전달한다.
    // void         : 몇 개 저장되었는지 반환하지 않는다.
    // int - return : 총 몇 개의 상품이 저장되었는지 SQL에서 반환한다.
    void insertGoods(Goods goods);

}
