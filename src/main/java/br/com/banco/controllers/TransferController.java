package br.com.banco.controllers;

import br.com.banco.services.TransferService;
import br.com.banco.entities.Transfer;

import java.util.List;
import java.time.OffsetDateTime;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/{accountId}")
    public List<Transfer> getTransfersByAccountId(
        @PathVariable("accountId") Integer accountId
    ) {
        return transferService.getTransfersByAccountId(accountId);
    }

    @GetMapping("/{accountId}/by-date")
    public List<Transfer> getTransfersByDate(
        @PathVariable("accountId") Integer accountId,
        @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime startDate,
        @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime endDate
    ) {
        return transferService.getTransfersByDate(startDate, endDate, accountId);
    }

    @GetMapping("/{accountId}/by-operator")
    public List<Transfer> getTransfersByOperatorName(
        @PathVariable("accountId") Integer accountId,
        @RequestParam("operatorName") String operatorName
    ) {
        return transferService.getTransfersByOperatorName(accountId, operatorName);
    }

    @GetMapping("/{accountId}/by-date-and-operator")
    public List<Transfer> getTransfersByDateAndOperatorName(
        @PathVariable("accountId") Integer accountId,
        @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime startDate,
        @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime endDate,
        @RequestParam("operatorName") String operatorName
    ) {
        return transferService.getTransfersByDateAndOperatorName(accountId, startDate, endDate, operatorName);
    }
}
