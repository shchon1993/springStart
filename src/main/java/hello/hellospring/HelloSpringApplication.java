package hello.hellospring; //<- 하위 패키지에 등록되어 있는 애름만 컴포넌트 스캔등록 가능하다.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//내장 tomcat, webserver
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
