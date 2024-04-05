package br.com.apifatec.apifatec.domain.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apifatec.apifatec.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}