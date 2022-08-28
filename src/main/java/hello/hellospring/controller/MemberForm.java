package hello.hellospring.controller;

public class MemberForm {
    private String name;

    public String getName(){
        return name;
    }

    public String setName(String name){
        return this.name = name;
    }
}
