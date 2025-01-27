package com.github.viniciusvk1.Ticket.Data.Pro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statusTicket;
    private String descricaoTicket;
    private String tipoAssociacao;
    private String identificacaoAssociacao;
    private String descricaoAssociacao;
    private String nomeSolicitante;
    private String nomeAvaliadorTecnico;
    private String tipoDesenvolvedor;
    private String nomeDesenvolvedor;
    private String prioridade;
    private String motivoSolicitacao;
    private String equipeTrabalho;
    private String modulo;
    private String etapa;
    private LocalDateTime dataCriacaoTicket;
    private LocalDateTime dataEncerramentoTicket;
    private String statusDocumento;
    private String tipoSolicitacao;
    private String documentoReprovado;
    private String motivoReprovacao;
    private String complexidade;
    private String volumeTrabalho;
    private Integer totalEsforcoPrevistoHs;
    private LocalDate prazoEntregaDesenvolvedor;
    private Integer totalEsforcoAdicionalHs;
    private Integer esforcoPrevistoMaisAdicionalHs;
    private Integer esforcoRealHs;
    private LocalDateTime terminoRealDesenvolvedor;
    private String statusDesenvolvimento;
    private String changeRequests;
    private LocalDateTime dataAtual;
    private LocalDateTime dataTratada;
    private LocalDateTime dataConvertida;

}
