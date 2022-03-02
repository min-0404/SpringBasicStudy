package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// 여기서 @Service 선언해주면, 이제 MemberService 클래스는 빈으로 등록되고,
// Controller 나 다른 클래스에서 MemberService 객체를 @Autowired 선언을 통해 마음껏 호출해 DI 할수 있게 된다.
//@Service : 해당 프로젝트에선 SpringConfig 에서 따로 등록해주자
@Transactional
public class MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 이런 방식보단 생성자 주입 하는 것이 훨씬 좋다

    // 생성자 주입 : 스프링 빈에 등록해놨던 리포지토리를 찾아옴
    //@Autowired : 해당 프로젝트에서는 SpringConfig 에서 따로 등록해주자
    private final MemberRepository memberRepository; // DI를 위해 선언만
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // 1. 회원 가입 기능
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 되는 아이디인지 검증
        memberRepository.save(member);
        return member.getId();
    }

    // 아이디 중복 검증 기능
    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    // 2. 전체 회원 조회 기능
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 3. 아이디입력시 해당 멤버 반환 기능
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
