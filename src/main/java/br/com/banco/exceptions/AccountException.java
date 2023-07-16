package br.com.banco.exceptions;

public class AccountException extends RuntimeException {
    
    public AccountException(String message) {
        super(message);
    }

    public static class AccountNotFoundException extends AccountException {
        
        public AccountNotFoundException(String message) {
            super(message);
        }
    }
}