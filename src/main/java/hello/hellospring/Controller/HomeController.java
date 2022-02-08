package hello.hellospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 웹 MVC 개발 1. 홈 화면 구현하기
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home"; // home.html 찾아감
    }
}