package br.com.ritchie.eurekademo.service;

import br.com.ritchie.eurekademo.domain.Ticket;
import br.com.ritchie.eurekademo.service.TicketService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

    @HystrixCommand(fallbackMethod = "defaulTicket")
    public Ticket findByProdutoid(Integer produtoId) {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://EUREKA-TICKET-SERVICE")
                .defaultCookie("cookie-name", "cookie-value")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();


        Ticket ticket = webClient.get()
                .uri("/ticket/produto/" + produtoId)
                .exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        log.info("Deu certo!!!");
                        return response.bodyToMono(Ticket.class);
                    } else if (response.statusCode().is4xxClientError()) {
                        log.info("Deu ruim!!!");
                        return Mono.just(new Ticket());
                    } else {
                        log.info("Deu muito ruim mesmo!!!");
                        return response.createException().flatMap(Mono::error);
                    }
                }).block();

        return ticket;

    }

    private Ticket defaulTicket(Integer produtoId){
        return new Ticket();
    }
}
