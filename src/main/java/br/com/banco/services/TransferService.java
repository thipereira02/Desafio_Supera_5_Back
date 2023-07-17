package br.com.banco.services;

import br.com.banco.dto.TransferDTO;
import br.com.banco.dto.TransferDTOList;
import br.com.banco.entities.Account;
import br.com.banco.entities.Transfer;
import br.com.banco.repositories.TransferRepository;
import br.com.banco.repositories.AccountRepository;
import br.com.banco.exceptions.AccountException;
import br.com.banco.utils.TransferUtils;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository, TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    private TransferDTO convertToDTO(Transfer transfer) {
        return new TransferDTO(
            transfer.getDataTransferencia(),
            transfer.getValor(),
            transfer.getTipo(),
            transfer.getNomeOperadorTransacao()
        );
    }

    public TransferDTOList getTransfersByAccountId(Integer accountId) {
        Account account = accountRepository.findByIdConta(accountId);
        if (account == null) {
            throw new AccountException.AccountNotFoundException("Conta não encontrada.");
        }
        
        List<Transfer> transfers =  transferRepository.findByContaId(accountId);

        List<TransferDTO> transferDTOs = transfers.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());

        return new TransferDTOList(transferDTOs, TransferUtils.calculateTotalBalance(transfers));
    }

    public List<TransferDTO> getTransfersByDate(OffsetDateTime startDate, OffsetDateTime endDate, Integer accountId) {
        List<Transfer> transfers = transferRepository.findByDateTransferencia(startDate, endDate, accountId);
        
        return transfers.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public List<TransferDTO> getTransfersByOperatorName(Integer accountId, String operatorName) {
        List<Transfer> transfers = transferRepository.findByNomeOperadorTransacao(accountId, operatorName);
        
        return transfers.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public List<TransferDTO> getTransfersByDateAndOperatorName(Integer accountId, OffsetDateTime startDate, OffsetDateTime endDate, String operatorName) {
        List<Transfer> transfers = transferRepository.findByDateTransferenciaAndNomeOperadorTransacao(accountId, startDate, endDate, operatorName);
        
        return transfers.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
}
