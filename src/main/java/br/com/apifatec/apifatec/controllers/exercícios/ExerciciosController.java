package br.com.apifatec.apifatec.controllers.exercícios;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.apifatec.apifatec.ApiFatecApplication;

public class ExerciciosController {
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
