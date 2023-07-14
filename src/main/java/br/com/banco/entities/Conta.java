package br.com.banco.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "conta")
@Data
@NoArgsConstructor
public class Conta {

    @Id
    @GeneratedValue
    @Column(name = "id_conta")
    private UUID idConta;

    @Column(name = "nome_responsavel", nullable = false)
    private String nomeResponsável;

    public Conta(String nomeResponsável) {
        this.nomeResponsável = nomeResponsável;
    }
    
}
