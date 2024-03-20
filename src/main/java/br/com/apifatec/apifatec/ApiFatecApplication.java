package br.com.apifatec.apifatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.apifatec.apifatec.domain.cliente.ClienteRepository;
import br.com.apifatec.apifatec.entities.Cliente;



@SpringBootApplication
public class ApiFatecApplication {
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository clienteRepository){
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setNome("Paulo César");
			cliente.setEmail("paulofatec@fatec.com.jp");
			cliente.setEndereco("Rua Joao Dois");
			cliente.setRazaoSocial("Paulo");

			clienteRepository.save(cliente);
		};
	}
	public static void main(String[] args){
		SpringApplication.run(ApiFatecApplication.class, args);
	}
	
}
