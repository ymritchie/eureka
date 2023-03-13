package br.com.ritchie.eurekademo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TICKETS")
public class Ticket {

    @Id
    @Column(name = "TICKETID")
    private Integer ticketId;

    @Column(name = "NUMEROPREMIADO")
    private Integer numeroPremiado;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PRODUTOID")
    private Integer produtoId;
}
