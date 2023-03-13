package br.com.ritchie.eurekademo.service;

import br.com.ritchie.eurekademo.domain.Ticket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface TicketService {
    @GetMapping(value = "/ticket/produto/{produtoId}")
    Ticket findByProdutoid (@PathVariable("produtoId") Integer produtoId);
}
