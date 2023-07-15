package br.com.banco.services;

import br.com.banco.entities.Transfer;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.time.OffsetDateTime;

@Service
public class TransferService {
    
    public List<Transfer> getTransfersByAccountId(Integer accountId, OffsetDateTime startDate, OffsetDateTime endDate, String operatorName) {

        System.out.println("accountId: " + accountId);
        System.out.println("startDate: " + startDate);
        System.out.println("endDate: " + endDate);
        System.out.println("operatorName: " + operatorName);

        return Collections.emptyList();
    }
}
