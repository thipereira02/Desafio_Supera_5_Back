package br.com.banco.services;

import br.com.banco.entities.Transfer;
import br.com.banco.repositories.TransferRepository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private final TransferRepository transferRepository;

    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public List<Transfer> getTransfersByAccountId(Integer accountId) {
        return transferRepository.findByContaId(accountId);
    }

    public List<Transfer> getTransfersByDate(OffsetDateTime startDate, OffsetDateTime endDate, Integer accountId) {
        return transferRepository.findByDateTransferencia(startDate, endDate, accountId);
    }

    public List<Transfer> getTransfersByOperatorName(Integer accountId, String operatorName) {
        return transferRepository.findByNomeOperadorTransacao(accountId, operatorName);
    }

    public List<Transfer> getTransfersByDateAndOperatorName(Integer accountId, OffsetDateTime startDate, OffsetDateTime endDate, String operatorName) {
        return transferRepository.findByDateTransferenciaAndNomeOperadorTransacao(accountId, startDate, endDate, operatorName);
    }
}
