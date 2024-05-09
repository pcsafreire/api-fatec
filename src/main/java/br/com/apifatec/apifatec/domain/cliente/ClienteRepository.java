package br.com.apifatec.apifatec.domain.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apifatec.apifatec.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    
}

