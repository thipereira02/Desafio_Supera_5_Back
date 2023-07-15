package br.com.banco.repositories;

import br.com.banco.entities.Transfer;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

public interface TransferRepository extends JpaRepository<Transfer, Integer>{
    
    @Query("SELECT t FROM Transfer t WHERE t.conta.idConta = :accountId")
    List<Transfer> findByContaId(Integer accountId);

    @Query("SELECT t FROM Transfer t WHERE t.dataTransferencia >= :startDate AND t.dataTransferencia <= :endDate AND t.conta.id = :accountId")
    List<Transfer> findByDateTransferencia(
        @Param("startDate") OffsetDateTime startDate, 
        @Param("endDate") OffsetDateTime endDate, 
        @Param("accountId") Integer accountId
    );

    @Query("SELECT t FROM Transfer t WHERE t.conta.id = :accountId AND t.nomeOperadorTransacao = :operatorName")
    List<Transfer> findByNomeOperadorTransacao(
        @Param("accountId") Integer accountId,
        @Param("operatorName") String operatorName
    );

    @Query("SELECT t FROM Transfer t WHERE t.dataTransferencia >= :startDate AND t.dataTransferencia <= :endDate AND t.conta.id = :accountId AND t.nomeOperadorTransacao = :operatorName")
    List<Transfer> findByDateTransferenciaAndNomeOperadorTransacao(
            @Param("accountId") Integer accountId,
            @Param("startDate") OffsetDateTime startDate, 
            @Param("endDate") OffsetDateTime endDate, 
            @Param("operatorName") String operatorName
    );

}
