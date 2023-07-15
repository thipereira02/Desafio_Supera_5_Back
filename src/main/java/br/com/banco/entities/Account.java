package br.com.banco.entities;

import javax.persistence.*;

@Entity
@Table(name = "conta")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Integer idConta;

    @Column(name = "nome_responsavel", nullable = false)
    private String nomeResponsável;

    public Account(String nomeResponsável) {
        this.nomeResponsável = nomeResponsável;
    }

    public Account() {

    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getNomeResponsável() {
        return nomeResponsável;
    }

    public void setNomeResponsável(String nomeResponsável) {
        this.nomeResponsável = nomeResponsável;
    }

}
