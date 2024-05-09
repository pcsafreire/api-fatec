package br.com.apifatec.apifatec;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import br.com.apifatec.apifatec.domain.cliente.ClienteRepository;
import br.com.apifatec.apifatec.entities.Cliente;
import br.com.apifatec.apifatec.entities.PedidoVenda;
import br.com.apifatec.apifatec.entities.PedidoVendaItem;
import br.com.apifatec.apifatec.domain.produto.ProdutoRepository;
import br.com.apifatec.apifatec.entities.Produto;
import br.com.apifatec.apifatec.domain.pedidovenda.PedidoVendaRepository;
import br.com.apifatec.apifatec.shared.enums.PedidoVendaStatusEnum;

@SpringBootApplication
public class ApiFatecApplication {
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository clienteRepository, ProdutoRepository produtoRepository, PedidoVendaRepository pedidoVendaRepository){
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setNome("Paulo César");
			cliente.setEmail("paulofatec@fatec.com.jp");
			cliente.setEndereco("Rua Joao Dois");
			cliente.setRazaoSocial("Paulo");
			clienteRepository.save(cliente);

            Produto produto1 = new Produto();
            produto1.setDescricao("Refrigerante");
            produto1.setPreco(new BigDecimal(10.0));
            produto1.setQuantidadeEstoque(100);
            produto1.setAtivo(true);
            produtoRepository.save(produto1);

            Produto produto2 = new Produto();
            produto2.setDescricao("Cerveja");
            produto2.setPreco(new BigDecimal(20.0));
            produto2.setQuantidadeEstoque(50);
            produto2.setAtivo(true);
            produtoRepository.save(produto2);
			
			PedidoVenda ped = new PedidoVenda();
			ped.setCliente(cliente);
			ped.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			LocalDate data = LocalDate.now();
			ped.setEmissao(data);

			//Instanciando PedidoVendaItem na variavel item1
			PedidoVendaItem item1 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item1.setProduto(produto1);
			item1.setQuantidade(10);
			item1.setValorUnitario(new BigDecimal(10));
			item1.setValorTotal(item1.getValorUnitario().multiply(BigDecimal.valueOf(item1.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped.addItem(item1);

			//Instanciando PedidoVendaItem na variavel item2
			PedidoVendaItem item2 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item2.setProduto(produto1);
			item2.setQuantidade(10);
			item2.setValorUnitario(new BigDecimal(10));
			item2.setValorTotal(item2.getValorUnitario().multiply(BigDecimal.valueOf(item2.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped.addItem(item2);

			//Calculando total dos itens do Pedido Venda
			ped.setTotal();

			//Salvando Pedido Venda
			pedidoVendaRepository.save(ped);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}
}