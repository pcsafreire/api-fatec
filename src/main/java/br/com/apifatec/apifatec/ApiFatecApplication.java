package br.com.apifatec.apifatec;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApiFatecApplication {
	
	@RequestMapping("/")
	String home() {
		return "Hello World";
	}
	
	@RequestMapping("/hello")
	String home2 () {
		return "Hello World 2";
	}
	
	@RequestMapping("/numero")
	Integer numero () {
		return 9;
	}

	@RequestMapping("/numero/{num}")
	Integer numero2 (@PathVariable Integer num) {
		return num;
	}
}
