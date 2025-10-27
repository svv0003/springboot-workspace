package com.example.demoTESTproject.controller;

import com.example.demoTESTproject.model.Goods;
import com.example.demoTESTproject.model.Products;
import com.example.demoTESTproject.repository.ProductsRepository;
import com.example.demoTESTproject.service.GoodsService;
import com.example.demoTESTproject.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// http://localhost:8080/       개발용 주소
// https://localhost:8080/      https 배포 후 클라이언트 사용 주소

/*
========================================================================================================================
@ 어노테이션            .java에 작성한 기능을 @명칭으로 축소하여 작성된 문서 기능을 사용한다.
                        기존 제공하는 어노테이션이 존재하며, 개발자가 별도로 생성하는 것도 가능하다.

                        기존 어노테이션 이외에 너무 많은 어노테이션을 사용할 경우,
                        어노테이션 개발자들이 만든 규약을 따라야 하고,
                        따르기 위해서는 어노테이션 사용자가 방대한 지식을
                        갖춰야 하기 때문에 많은 사용은 지양한다.
========================================================================================================================
@Controller             .html과 연결할 때 사용하는 어노테이션.
                        JSP의 경우에는 .html이 인텔리제이 내부에서 사용될 것이기 때문에 @Controller 사용한다.
                        React로 만든 프로젝트를 프론트엔드에서 build 작업을 하고 나면
                        React에서 만든 프론트엔드 또한 @RestController -> @Controller로 변경해야 한다.
@RestController         DB 또는 SNS 로그인, 토큰 같은 데이터를 전송할 때 사용하는 어노테이션.
                        React와 연결 작업하여 코딩할 경우에는 주로 @RestController 사용한다.


========================================================================================================================
http 메서드 (=기능) 매핑 어노테이션
========================================================================================================================
@RequestMapping("/주소들")     아래 작성한 http 메서드를 사용하기 전에 많이 사용했던 방법
                               특정 Controller의 전체 시작하는 주소 명칭을 묶어서 작성하기도 한다.
------------------------------------------------------------------------------------------------------------------------
@GetMappging("/주소들")        DB에서 데이터를 가져온 후 프론트엔드에서 조회할 때 주로 사용한다.
                               이외에도 이메일 인증이나 다양한 작업을 하기도 한다.
@PostMappging("/주소들")       프론트엔드에서 전달받은 데이터를 DB에 저장할 때 사용한다.
@PutMappging("/주소들")        프론트엔드에서 전달받은 데이터로 기존 저장 데이터를 전체 수정할 때 사용한다.
@PatchMappging("/주소들")      프론트엔드에서 전달받은 데이터로 기존 저장 데이터를 부분 수정할 때 사용한다.
@DeleteMappging("/주소들")     DB 내부에 존재하는 데이터를 제거할 때 사용한다.
 */

@RestController
public class IndexController {

    @Autowired
    private ProductsService productsService;

    /*
    위처럼 작성하면 기존에 작성해왔던 방식 생략 가능하다.

    Products products = new Products();
    products. ;
     */

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/products/all")
    public List<Products> findAll() {
        return productsService.findAll();
    }


    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods/all")
    public List<Goods> findAllGoods() {
        return goodsService.findAll();
    }
}
