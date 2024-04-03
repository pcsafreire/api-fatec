package br.com.apifatec.apifatec.controllers.exercícios;

import java.util.List;

import br.com.apifatec.apifatec.domain.cliente.ClienteService;
//import br.com.apifatec.apifatec.domain.cliente.ClienteMapper;
//import br.com.apifatec.apifatec.domain.cliente.ClienteDTO;
import br.com.apifatec.apifatec.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/clientes/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	/*
		Listar todos clientes cadastrados
	*/
	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> clientes = clienteService.listarClientes();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	/*
		Buscar cliente por Id
	*/
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> encontrarClientePorId(@PathVariable Long id) {
		Cliente cliente = clienteService.encontrarClientePorId(id);
		return cliente != null ? new ResponseEntity<>(cliente, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/*
		Criar novo cliente
	*/
	@PostMapping
	public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteService.salvarCliente(cliente);
		return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
	}
	
	/*
		Excluir cliente pelo Id
	*/
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}