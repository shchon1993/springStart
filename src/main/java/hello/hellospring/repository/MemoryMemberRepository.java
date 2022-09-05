package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

//DB 접근, 도메인 객체 DB 에 저장하고 관리
//@Repository //스프링이 올라올때 스프링 컨테이너에 MemoryMemberRepository 객체를 생성해서 스프링에 넣어놓고 관리한다. 스프링컨테이너에서 스프링 빈이 관리된다.
public class MemoryMemberRepository implements MemberRepository{

    //Map<key,value>
    private static Map<Long, Member> store = new HashMap<>();
    private static long seq  = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++seq);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null check
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //루프 돌려서
                .filter(member -> member.getName().equals(name)) //member.getName이 파라미터로 넘어온 name이랑 같으면 필터링 되어
                .findAny(); //하나라도 찾으면 반환
        //java8 람다 공부하자
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store에 들어있는 전체 member 반환
    }

    public void clearStore(){
         store.clear();
    }
}
