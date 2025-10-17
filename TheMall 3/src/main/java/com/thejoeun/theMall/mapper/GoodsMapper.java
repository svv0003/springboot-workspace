package com.thejoeun.theMall.mapper;

import com.thejoeun.theMall.model.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
Repository의 경우
스프링부트 개발자와 커뮤니티 개발자들이 만들어 놓은 기능을
JPA에서 가져와서 사용하는 것이다.

Mapper의 경우
resource/mappers/ 폴더 아래에 각 회사 개발자들이 작성한
SQL을 기반으로 움직이는 기능 명칭들을 작성한다.

mapper.xml 파일에 id로 작성한 명칭과
class Mapper.java에서 작성하는 기능 명칭이
일치해야 xml 파일에 작성한 SQL 구문이 동작한다.
<select id="getAllGoods" resultMap="goodsResultMap">
 */

// @Repository와 동일한 위치
@Mapper
public interface GoodsMapper {

    // 모든 상품 조회
    // id="getAllGoods"에서 작성한 SQL을 기반으로
    // 모든 데이터를 List 목록 형태로 가져올 것이다.
    List<Goods> getAllGoods();

    void insertGoods(Goods goods);

}