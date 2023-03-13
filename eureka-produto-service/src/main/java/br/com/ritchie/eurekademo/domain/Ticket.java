package br.com.ritchie.eurekademo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1;

    private Integer ticketId;

    private Integer numeroPremiado;

    private String status;
}
