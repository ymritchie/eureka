package br.com.ritchie.eurekademo.controller;

import br.com.ritchie.eurekademo.domain.Ticket;
import br.com.ritchie.eurekademo.repository.TicketRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
@Api(tags = {"Api de Tickets"})
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping
    public Iterable<Ticket> findAll(){
        return this.ticketRepository.findAll();
    }

    @GetMapping(value = "/{numeroTicket}")
    public Ticket findByTicket(@PathVariable Integer numeroTicket){
        return this.ticketRepository.findByNumeroPremiado(numeroTicket);
    }

    @GetMapping(value = "/produto/{produtoId}")
    public Ticket findByTicketProduto(@PathVariable Integer produtoId){
        return this.ticketRepository.findAllByProdutoId(produtoId);
    }


}
