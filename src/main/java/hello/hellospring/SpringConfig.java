package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

//자바코드로 직접 스프링 빈 등록
//컨트롤러는 자동으로 올라오기 때문에 컨트롤러 자체에서 serice와 연결 시켜 주면 된다.
@Configuration
public class SpringConfig {

   // private DataSource dataSource;
//    @Autowired
//  public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//   }

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public MemberService memberService(){ //스프링컨테이너에 MemberService 객체 생성
        return new MemberService(memberRepository()); //@Autowired 동일한 역할 MemberService와 MemoryMemberRepository 연결
    }
/*
    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }
*/
    @Bean
    public JpaMemberRepository memberRepository(){ //스프링컨테이너에 MemoryMemberRepository 객체 생성
       // return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
       // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
