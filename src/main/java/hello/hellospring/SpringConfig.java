package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.swing.*;

// 스프링 빈을 자바코드로 직접 등록해주는 클래스
@Configuration
public class SpringConfig {
    // 직접 코드로 멤버 서비스와 멤버 레퍼지토리를 빈으로 등록해주기

    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    //@Bean
    //public MemberRepository memberRepository(){
        // return new MemoryMemberRepository();  다른 클래스로 연결해주기 => 인터페이스의 장점
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    //}
}
