package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    //MemberService memberService = new MemberService(memberRepository);
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository(); //test는 다른 객체, MemoryMemberRepository와 다름.

    //DI = Dependency Injection
    MemberService memberService;
    MemoryMemberRepository memberRepository;
    @BeforeEach
    public void beforeEach(){
        //테스트를 실행할때마다 아래 객체를 만들어서 같은
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); //생성자로 생성. 같은 MemberRepository가 사용
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given 주어지고
        Member member = new Member();
        member.setName("spring");

        //when 싫랭했을때
        Long saveId = memberService.join(member);

        //then 결과가 이렇게 나와야됨
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName()); // static import alt + enter
    }

    @Test
    public void 중복회원예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    /*
        try{
            memberService.join((member2));
           // fail();
        }catch(IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
    */
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne(){

    }
}