package br.com.ritchie.eurekademo.repository;

import br.com.ritchie.eurekademo.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
