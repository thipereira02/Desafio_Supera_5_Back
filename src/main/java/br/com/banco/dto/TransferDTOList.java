package br.com.banco.dto;

import java.util.List;

import java.math.BigDecimal;

public class TransferDTOList {
    private List<TransferDTO> transfers;
    private BigDecimal totalBalance;

    public TransferDTOList(List<TransferDTO> transfers, BigDecimal totalBalance) {
        this.transfers = transfers;
        this.totalBalance = totalBalance;
    }

    public List<TransferDTO> getTransfers() {
        return transfers;
    }

    public BigDecimal gettotalBalance() {
        return totalBalance;
    }
}