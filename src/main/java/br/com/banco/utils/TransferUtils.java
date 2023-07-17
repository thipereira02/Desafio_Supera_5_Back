package br.com.banco.utils;

import br.com.banco.entities.Transfer;

import java.math.BigDecimal;
import java.util.List;

public class TransferUtils {
    
    public static BigDecimal calculateTotalBalance(List<Transfer> transfers) {
        BigDecimal totalBalance = new BigDecimal(0);
        for (Transfer transfer : transfers) {
            totalBalance = totalBalance.add(transfer.getValor());
        }
        return totalBalance;
    }
}
