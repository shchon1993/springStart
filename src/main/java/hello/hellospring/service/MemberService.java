package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//핵심 비즈니스 로직
//@Service //스프링이 올라올때 스프링 컨테이너에 MemberService 객체를 생성해서 스프링에 넣어놓고 관리한다. 스프링컨테이너에서 스프링 빈이 관리된다.
@Transactional
public class MemberService {
    //private final MemberRepository memberRepository = new MemoryMemberRepository(); //test에서 생성한거랑 다른 인스턴스임
    private final MemberRepository memberRepository;

    //DI = Dependency Injection
    //@Autowired //연결시켜준다. 스프링 컨테이너에 있는 MemberRepository 가져다가 연결 시켜줌 이게 바로 Dependendy Injection(의존관계 주입)
    public MemberService(MemberRepository memberRepository) { //외부에서 넣어줄 수 있도록
        this.memberRepository = memberRepository;
    }

    /*
      회원 가입
     */
    public Long join(Member member){
        //리팩토링 ctrl + alt + V
        //같은 이름이 있는 중복 회원 X
        /*Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });*/
        validateDuplicateMember(member); //메서드 생성 ctrl + alt + M
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m-> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /*
        전체 회원 조회
     */
    public List<Member> findMembers() {
            return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
