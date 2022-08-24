package hello.hellospring.domain;


//비즈니스 도메인 객체 -> 회원,주문,쿠폰 등등 주로 DB에 저장하고 관리됨
public class Member {
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
