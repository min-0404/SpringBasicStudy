package hello.hellospring.Controller;

import hello.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // 정적 컨텐츠 기본 방식
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello"; // static 파일에서 hello.html 찾아냄
    }

    @GetMapping("hello-mvc") // mvc의 기본 방식 => 템플릿엔진 이용
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template"; // templates 파일에서 hello-template.html 찾아냄
    }

    @GetMapping("hello-API") // API의 기본방식 => 템플릿 엔진 거치지 않음(단순한 문자열 형식)
    @ResponseBody
    public String helloAPI(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-API2") // API 방식으로 객체 반환하기(JSON 형식)
    @ResponseBody
    public Hello helloAPI2(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체를 JSON 형태로 반환해준다
    }

    // API 실습을 위해 생성해놓은 객체
    static class Hello{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }


}
