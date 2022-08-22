package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

        MemoryMemberRepository repository = new MemoryMemberRepository();

        //전체 테스트시 메소드 순서는 보장이 안됨. 따라서 메소드별 동일한 이름의 객체 생성시 객체를 지워주지 않으면 에러 발생
        //Callback 함수 기능, 메소드가 하나 끝날때마다 아래 메소드 수행.
        @AfterEach
        public void afterEach(){
                repository.clearStore();
        }

        @Test
        public void save(){
                Member member = new Member();
                member.setName("spring");

                repository.save(member);

                Member result = repository.findById(member.getId()).get();
                //System.out.println("result = " + (result == member));
                //Assertions.assertEquals(member,result);
                Assertions.assertThat(member).isEqualTo(result);


        }

        @Test
        public void findByName(){
                Member member1 = new Member();
                member1.setName("spring1");
                repository.save(member1);

                Member member2 = new Member(); // shift + F6 동일한 문자 전체 변경
                member2.setName("spring2");
                repository.save(member2);

                Member result = repository.findByName("spring1").get();

                Assertions.assertThat(result).isEqualTo(member1);
        }

        @Test
        public void findAll(){
                Member member1 = new Member();
                member1.setName("spring1");
                repository.save(member1);

                Member member2 = new Member(); // shift + F6 동일한 문자 전체 변경
                member2.setName("spring2");
                repository.save(member2);

                List<Member> result = repository.findAll();
                Assertions.assertThat(result.size()).isEqualTo(2);


        }




}
