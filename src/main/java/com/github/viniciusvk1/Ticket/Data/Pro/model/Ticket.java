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

    public String getStatusTicket() {
        return statusTicket;
    }

    public void setStatusTicket(String statusTicket) {
        this.statusTicket = statusTicket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoTicket() {
        return descricaoTicket;
    }

    public void setDescricaoTicket(String descricaoTicket) {
        this.descricaoTicket = descricaoTicket;
    }

    public String getTipoAssociacao() {
        return tipoAssociacao;
    }

    public void setTipoAssociacao(String tipoAssociacao) {
        this.tipoAssociacao = tipoAssociacao;
    }

    public String getIdentificacaoAssociacao() {
        return identificacaoAssociacao;
    }

    public void setIdentificacaoAssociacao(String identificacaoAssociacao) {
        this.identificacaoAssociacao = identificacaoAssociacao;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    public String getDescricaoAssociacao() {
        return descricaoAssociacao;
    }

    public void setDescricaoAssociacao(String descricaoAssociacao) {
        this.descricaoAssociacao = descricaoAssociacao;
    }

    public String getNomeAvaliadorTecnico() {
        return nomeAvaliadorTecnico;
    }

    public void setNomeAvaliadorTecnico(String nomeAvaliadorTecnico) {
        this.nomeAvaliadorTecnico = nomeAvaliadorTecnico;
    }

    public String getTipoDesenvolvedor() {
        return tipoDesenvolvedor;
    }

    public void setTipoDesenvolvedor(String tipoDesenvolvedor) {
        this.tipoDesenvolvedor = tipoDesenvolvedor;
    }

    public String getNomeDesenvolvedor() {
        return nomeDesenvolvedor;
    }

    public void setNomeDesenvolvedor(String nomeDesenvolvedor) {
        this.nomeDesenvolvedor = nomeDesenvolvedor;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getMotivoSolicitacao() {
        return motivoSolicitacao;
    }

    public void setMotivoSolicitacao(String motivoSolicitacao) {
        this.motivoSolicitacao = motivoSolicitacao;
    }

    public String getEquipeTrabalho() {
        return equipeTrabalho;
    }

    public void setEquipeTrabalho(String equipeTrabalho) {
        this.equipeTrabalho = equipeTrabalho;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public LocalDateTime getDataCriacaoTicket() {
        return dataCriacaoTicket;
    }

    public void setDataCriacaoTicket(LocalDateTime dataCriacaoTicket) {
        this.dataCriacaoTicket = dataCriacaoTicket;
    }

    public LocalDateTime getDataEncerramentoTicket() {
        return dataEncerramentoTicket;
    }

    public void setDataEncerramentoTicket(LocalDateTime dataEncerramentoTicket) {
        this.dataEncerramentoTicket = dataEncerramentoTicket;
    }

    public String getStatusDocumento() {
        return statusDocumento;
    }

    public void setStatusDocumento(String statusDocumento) {
        this.statusDocumento = statusDocumento;
    }

    public LocalDateTime getDataConvertida() {
        return dataConvertida;
    }

    public void setDataConvertida(LocalDateTime dataConvertida) {
        this.dataConvertida = dataConvertida;
    }

    public LocalDateTime getDataTratada() {
        return dataTratada;
    }

    public void setDataTratada(LocalDateTime dataTratada) {
        this.dataTratada = dataTratada;
    }

    public LocalDateTime getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDateTime dataAtual) {
        this.dataAtual = dataAtual;
    }

    public String getChangeRequests() {
        return changeRequests;
    }

    public void setChangeRequests(String changeRequests) {
        this.changeRequests = changeRequests;
    }

    public String getStatusDesenvolvimento() {
        return statusDesenvolvimento;
    }

    public void setStatusDesenvolvimento(String statusDesenvolvimento) {
        this.statusDesenvolvimento = statusDesenvolvimento;
    }

    public Integer getEsforcoRealHs() {
        return esforcoRealHs;
    }

    public void setEsforcoRealHs(Integer esforcoRealHs) {
        this.esforcoRealHs = esforcoRealHs;
    }

    public LocalDateTime getTerminoRealDesenvolvedor() {
        return terminoRealDesenvolvedor;
    }

    public void setTerminoRealDesenvolvedor(LocalDateTime terminoRealDesenvolvedor) {
        this.terminoRealDesenvolvedor = terminoRealDesenvolvedor;
    }

    public Integer getEsforcoPrevistoMaisAdicionalHs() {
        return esforcoPrevistoMaisAdicionalHs;
    }

    public void setEsforcoPrevistoMaisAdicionalHs(Integer esforcoPrevistoMaisAdicionalHs) {
        this.esforcoPrevistoMaisAdicionalHs = esforcoPrevistoMaisAdicionalHs;
    }

    public Integer getTotalEsforcoAdicionalHs() {
        return totalEsforcoAdicionalHs;
    }

    public void setTotalEsforcoAdicionalHs(Integer totalEsforcoAdicionalHs) {
        this.totalEsforcoAdicionalHs = totalEsforcoAdicionalHs;
    }

    public LocalDate getPrazoEntregaDesenvolvedor() {
        return prazoEntregaDesenvolvedor;
    }

    public void setPrazoEntregaDesenvolvedor(LocalDate prazoEntregaDesenvolvedor) {
        this.prazoEntregaDesenvolvedor = prazoEntregaDesenvolvedor;
    }

    public Integer getTotalEsforcoPrevistoHs() {
        return totalEsforcoPrevistoHs;
    }

    public void setTotalEsforcoPrevistoHs(Integer totalEsforcoPrevistoHs) {
        this.totalEsforcoPrevistoHs = totalEsforcoPrevistoHs;
    }

    public String getComplexidade() {
        return complexidade;
    }

    public void setComplexidade(String complexidade) {
        this.complexidade = complexidade;
    }

    public String getVolumeTrabalho() {
        return volumeTrabalho;
    }

    public void setVolumeTrabalho(String volumeTrabalho) {
        this.volumeTrabalho = volumeTrabalho;
    }

    public String getDocumentoReprovado() {
        return documentoReprovado;
    }

    public void setDocumentoReprovado(String documentoReprovado) {
        this.documentoReprovado = documentoReprovado;
    }

    public String getMotivoReprovacao() {
        return motivoReprovacao;
    }

    public void setMotivoReprovacao(String motivoReprovacao) {
        this.motivoReprovacao = motivoReprovacao;
    }

    public String getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(String tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }
}
