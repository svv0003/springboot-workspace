package thejoeun.shopping.TheMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// @RestController  -> DB에 존재하는 데이터를 JSON 형태로 설정한 주소에 데이터 전달한다.
//                     ReactJS 빌드 전에 사용하는 방법

// @Controller      -> return에서 개발자가 원하는 html 페이지로 이동한다.
//                     ReactJS와 같은 프론트엔드 프로젝트 빌드 후 진행하는 작업

/*
하나의 폴더 파일에서 백엔드 프론트엔드 작업할 경우,
Controller만 사용해서 데이터를 주고 받을 수 있지만
하나의 폴더에서는 백엔드 작업, 하나의 폴더에서는 프론트엔드 작업하고,
그 둘의 주소 또는 포트가 다르다면 Controller에서는
RestController JSON 형태의 데이터를 프론트엔드에 전달해야 한다.
 */

@Controller
public class IndexController {

    // @GetMapping      -> DB 또는 특정 데이터를 조회하는 주소를 나타낸다.
    // 슬래시(/)를 단독 사용할 경우, 도메인주소나 포트 작성 후 아무것도 작성 안 해도 된다.
    // 슬래시(/)는 main 페이지를 나타내는 형태이고, 주로 index.html 명칭으로 사용된다.
    @GetMapping("/")
    public String index() {

        // model 변수명으로 전달받은 데이터를 전달하는 코드를 기입한다.
        return "index";
    }
}

