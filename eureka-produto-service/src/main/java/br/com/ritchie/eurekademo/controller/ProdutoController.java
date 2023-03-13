package br.com.ritchie.eurekademo.controller;

import br.com.ritchie.eurekademo.domain.Produto;
import br.com.ritchie.eurekademo.repository.ProdutoRepository;
import br.com.ritchie.eurekademo.service.TicketService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
@Api(tags = {"Api de Produtos"})
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private TicketService ticketService;


    @GetMapping()
    public Iterable<Produto> all (){
        return produtoRepository.findAll();
    }

    @GetMapping(value = "/{produtoId}")
    public Produto findByAccountId (@PathVariable Integer produtoId){

        Produto produto = produtoRepository.getById(produtoId);

        produto.setTicket(ticketService.findByProdutoid(produtoId));

        return produto;
    }


}
