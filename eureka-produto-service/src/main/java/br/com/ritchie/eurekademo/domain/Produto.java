package br.com.ritchie.eurekademo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="PRODUTOID")
    Integer produtoId;

    @Column(name="PRODUTONAME")
    String produtoName;

    @Transient
    Ticket ticket;
}
