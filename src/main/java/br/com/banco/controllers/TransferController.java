package br.com.banco.controllers;

import br.com.banco.services.TransferService;
import br.com.banco.entities.Transfer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/{accountId}")
    public List<Transfer> getTransfersByAccountId(
        @PathVariable("accountId") Integer accountId, 
        @RequestParam(value = "startDate", required = false) OffsetDateTime startDate, 
        @RequestParam(value = "endDate", required = false) OffsetDateTime endDate,
        @RequestParam(value = "operatorName", required = false) String operatorName) {
        return transferService.getTransfersByAccountId(accountId, startDate, endDate, operatorName);
    }
}
