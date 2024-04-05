package br.com.apifatec.apifatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.apifatec.apifatec.domain.cliente.ClienteRepository;
import br.com.apifatec.apifatec.entities.Cliente;
import br.com.apifatec.apifatec.entities.Produto;



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

			// Inicializa alguns produtos de exemplo
            Produto produto1 = new Produto();
            produto1.setDescricao("Produto 1");
            produto1.setPreco(10.0);
            produto1.setQuantidadeEstoque(100);
            produto1.setAtivo(true);
            produtoRepository.save(produto1);

            Produto produto2 = new Produto();
            produto2.setDescricao("Produto 2");
            produto2.setPreco(20.0);
            produto2.setQuantidadeEstoque(50);
            produto2.setAtivo(true);
            produtoRepository.save(produto2);
		};
	}
	public static void main(String[] args){
		SpringApplication.run(ApiFatecApplication.class, args);
	}
	
}
