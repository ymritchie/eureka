package br.com.ritchie.eurekademo.repository;

import br.com.ritchie.eurekademo.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    Ticket findByNumeroPremiado(Integer numeroPremiado);

    Ticket findAllByProdutoId(Integer produtoId);
}
