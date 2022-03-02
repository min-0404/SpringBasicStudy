package hello.hellospring.Controller.Member;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    //private final MemberService memberService = new MemberService();
    // 이렇게 객체 직접 만드는 것보단, 스프링 컨테이너에 등록해서 사용해야 한다 -> 생성자 활용

    private final MemberService memberService; // 선언만
    @Autowired // 생성자에서 @AutoWired 를 쓰면 MemberController 가 생성이 될때, 이미 "스프링 빈에 등록되어 있는 객체"를 가져다가 넣어줌
    public MemberController(MemberService memberService){ // MemberService 는 이미 빈으로 등록해놨기에 사용 가능
        this.memberService = memberService;
    }

    // 웹 MVC 개발 : 2. 가입 기능 구현
    // 2-1) @GetMapping 사용
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    // 2-2) @PostMapping 사용

    // 안좋은 방법 : @RequestParam 쓰면 되는데 뭐하러 이런 방법을 쓸 필요가 없다.
    /* @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/"; // 회원가입 끝났으니 홈으로 돌려보내는 기능
    }*/

    @PostMapping("/members/new")
    public String create(@RequestParam String name){
        Member member = new Member();
        member.setName(name);
        memberService.join(member);
        return "redirect:/"; // 회원가입 끝났으니 다시 홈으로 돌려보내는 기능
    }

    // 웹 MVC 개발 : 3. 회원 조회 기능 구현
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}