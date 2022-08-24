package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

//DB 접근, 도메인 객체 DB 에 저장하고 관리
//인터페이스 : 극단적으로 동일한 목적하에 동일한 기능을 보장하기 위함(다중상속)
// 자바의 다형성을 이용하여 개발코드 수정을 줄이고 유지보수성을 높인다.
//1. 대규모 프로젝트 개발 시 일관되고 정형화된 개발을 위한 표준화가 가능합니다.
//2. 클래스의 작성과 인터페이스의 구현을 동시에 진행할 수 있으므로, 개발 시간을 단축할 수 있습니다.
//3. 클래스와 클래스 간의 관계를 인터페이스로 연결하면, 클래스마다 독립적인 프로그래밍이 가능합니다.
//@Repository //스프링이 올라올때 스프링 컨테이너에 MemberRepository 객체를 생성해서 스프링에 넣어놓고 관리한다. 스프링컨테이너에서 스프링 빈이 관리된다.
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //null check -> java8
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
