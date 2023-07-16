package br.com.banco.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class TransferDTO {
    private OffsetDateTime dataTransferencia;
    private BigDecimal valor;
    private String tipo;
    private String nomeOperadorTransacao;

    public TransferDTO() {
    }

    public TransferDTO(OffsetDateTime dataTransferencia, BigDecimal valor, String tipo, String nomeOperadorTransacao) {
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }

    public OffsetDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(OffsetDateTime dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeOperadorTransacao() {
        return nomeOperadorTransacao;
    }

    public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }
}
