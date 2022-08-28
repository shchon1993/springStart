package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") //도메인 처음 localhost:8080 치면 접속 되는 경로
    //템플릿에 home.html 파일이 있는지 먼저 확인함. 없으면 static에서 index.html 파일 실행
    public String Home(){
        return "home";
    }
}
