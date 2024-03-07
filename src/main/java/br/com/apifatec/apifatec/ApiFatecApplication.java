package br.com.apifatec.apifatec;

import org.springframework.boot.SpringApplication;
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

	@RequestMapping("/idade/{num}")
	String idade(@PathVariable String num) {
		int n;
		
		try{
		     n = Integer.parseInt(num);
		     
		     if(n <= 0) {
		    	 return "Idade inválida.";
		     }
				
			 if( n < 12 ) {
				 return "Criança";
			 }
			 else if (n < 19) {
				 return "Adolescente";
			 }
			 else if(n < 61) {
				 return "Adulto";
			 }
			 else {
				return "Idoso";
			}
		}
		catch (NumberFormatException ex){

		}
		    return "Idade inválida";
		}

	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}

}
