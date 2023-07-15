package br.com.banco.entities;

import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Transferencia {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID idTransferencia;

    @Column(name = "data_transferencia", nullable = false)
    private LocalDateTime dataTransferencia;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String tipo;

    @Column(name = "nome_operador_transacao", nullable = false)
    private String nomeOperadorTransacao;

    @ManyToOne
    @JoinColumn(name = "id_conta_origem", nullable = false)
    private Conta conta;

    public Transferencia(LocalDateTime dataTransferencia, BigDecimal valor, String tipo, String nomeOperadorTransacao, Conta conta) {
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
        this.conta = conta;
    }
}
