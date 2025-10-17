package com.thejoeun.theMall.controller;

import com.thejoeun.theMall.mapper.GoodsMapper;
import com.thejoeun.theMall.model.Goods;
import com.thejoeun.theMall.model.User;
import com.thejoeun.theMall.service.GoodsService;
import com.thejoeun.theMall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 데이터 조회, 데이터 저장, 데이터 수정, 데이터 삭제
@CrossOrigin("*")
@RestController
public class 페이지이동이외모든작업Controller {

    // 서비스
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    // 서비스에 관련된 주소 작성하기.

    /*
    ResponseBody
    Java 객체를 JSON 형태로 변환하여 클라이언트 응답한다.
    RestController  어노테이션에는 이 기능이 존재하지 않아서 굳이 작성할 필요 없다.
    Controller에서 부분적으로 JSON 형태 변환이 필요할 경우 사용한다.
    ================================================================
    RequestBody
    클라이언트가 보낸 JSON 형태의 데이터를 Java 형태로 변환한다.
    POST, PUT 요청을 DB로 저장, 수정할 대 주로 사용한다.
     */

    // js에서 데이터 등록하는 hetch promise, axios ajax와 동일한 주소를 가져야 한다.
    @PostMapping("/api/goods")
    public void insertGoods(@RequestBody Goods goods){
        goodsService.insertGoods(goods);
    }

    @GetMapping("/api/goods")
    public List<Goods> getAllGoods(){
        return goodsService.getAllGoods();
    }

    @GetMapping("/api/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

}
