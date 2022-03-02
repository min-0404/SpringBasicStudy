package hello.hellospring.Controller.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 1. 정적 컨텐츠 전달해보기
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "minseok's first spring project"); // 모델명: data, 전달내용: hello!
        return "hello/hello"; // static 파일에서 hello.html 찾아냄
    }

    // 2. mvc 의 기본 => 템플릿 엔진 이용
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ // 쿼리에 담긴 데이터 가져옴
        model.addAttribute("name", name); // 모델에 데이터를 담아서 뷰에게 전달해줌
        return "hello/hello-template"; // templates 파일에서 hello-template.html 찾아냄
    }

    // 3. API 의 기본 => 순수한 문자열만 반환하는 경우
    @ResponseBody
    @GetMapping("hello-API")
    public String helloAPI(@RequestParam("name") String name){ // 쿼리에 담긴 데이터 가져옴
        return "hello " + name; // 순수한 문자열 반환 => 바디에 담김
    }

    // 4. API 의 기본 => 객체를 반환하는 경우
    @ResponseBody
    @GetMapping("hello-API2")
    public Hello helloAPI2(@RequestParam("name") String name){ // 반환형이 객체인것에 유의 !!
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체를 JSON 형태로 반환해준다 (by JsonConverter)
    }


    // 4번 API 실습을 위해 임시로 생성해놓은 객체
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

