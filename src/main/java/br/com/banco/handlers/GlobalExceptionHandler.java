package br.com.banco.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.banco.exceptions.AccountException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(AccountException.AccountNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleAccountNotFoundException(AccountException.AccountNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
