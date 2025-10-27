package edu.thejoeun.goodscommunity.main.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

// api 주소와 .html 연결을 작성하는 공간
@Controller
public class MainController {
    /**
     * http://localhost:8080/sign 으로 접속하면
     * @return pages 폴더 내부에 존재하는 signup.html 화면이 보임
     */
    @GetMapping("/sign")
    public String pageSignUp(){
        return "pages/signup";
    }

    @GetMapping("/board")
    public String pageBoard(){
        return "pages/board/boardList.html";
    }

    // 상세보기 페이지
    /*
    @GetMapping("/board/detail/{id}") http://localhost:8080/board/detail/1

    상세보기는 일반적으로 ? 쿼리 형태의 http://localhost:8080/board/detail?id=1 형태로 id를 읽어 게시물을 조회한다.

    @GetMapping("/board/detail/id={id}")
    public String pageBoardDetail(@PathVariable int id){
        return "pages/board/boardDetail.html";
    }
     */
    @GetMapping("/board/detail")
    public String pageBoardDetail(@RequestParam int id){
        return "pages/board/boardDetail.html";
    }
}
