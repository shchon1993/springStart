package hello.hellospring.domain;


import jdk.jfr.Name;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

//비즈니스 도메인 객체 -> 회원,주문,쿠폰 등등 주로 DB에 저장하고 관리됨
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 생성해줌. //pk
    private Long Id;
    private String name;


    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
