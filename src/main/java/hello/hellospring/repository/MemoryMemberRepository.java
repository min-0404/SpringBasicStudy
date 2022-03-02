package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// 만약, 여기서 @Repository 붙여주면, 이제 MemoryMemberRepository 가 스프링 빈으로 등록되고,
// Controller 나 다른 클래스에서 @Autowired 를 통해서 언제든지 호출해서 연결 가능
// @Repository : 해당 프로젝트에서는 SpringConfig 에서 따로 등록하자
public class MemoryMemberRepository implements MemberRepository {




    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }
}


