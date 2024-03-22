package br.com.apifatec.apifatec.domain.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apifatec.apifatec.entities.Cliente;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}

	public Cliente encontrarClientePorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}