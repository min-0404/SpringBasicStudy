package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // 테스트 끝날때, 디비에 널어줬던 데이터들 싹 다 삭제해줌
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService; // test는 대충 해도 되서 그냥 필드 주입
    @Autowired MemberRepository memberRepository; // test는 대충 해도 되서 그냥 필드 주입

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("minseok");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void 중복_회원_예외(){
        // Given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

        //memberService.join(member1);
        //try {
        //    memberService.join(member2);
        //    fail();
        //}catch (IllegalStateException e){
        //    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 12345");
        //}

        // then



    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}