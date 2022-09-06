package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "CSH");
        return "hello"; //hello,html return을 hello로 했으니 viewResolver가 resources:templets/hello.html을 찾아 호출한다.
    }

    //get방식으로 파라미터 name 넘김.
    //mvc의 기초.
    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";

    }

    @GetMapping("hello-string")
    @ResponseBody //viewResolver를 사용하지 않는다. get방식으로 파라미터를 넘겨 url 호출.
    public String hellospring(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody //HTTP의 BODY에 문자 내용을 직접 반환
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //json 으로 return -> 객체기 때문에 JsonConverter 호출

    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }




}
