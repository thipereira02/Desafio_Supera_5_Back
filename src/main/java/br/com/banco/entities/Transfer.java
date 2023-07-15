package br.com.banco.entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.*;

@Entity
@Table(name = "transferencia")
public class Transfer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idTransferencia;

    @Column(name = "data_transferencia", nullable = false)
    private OffsetDateTime dataTransferencia;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String tipo;

    @Column(name = "nome_operador_transacao", nullable = false)
    private String nomeOperadorTransacao;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Account conta;

    public Transfer(OffsetDateTime dataTransferencia, BigDecimal valor, String tipo, String nomeOperadorTransacao, Account conta) {
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
        this.conta = conta;
    }
}
