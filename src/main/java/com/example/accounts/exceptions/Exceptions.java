package com.example.accounts.exceptions;

import com.fortune.bank.commons.UniversalResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exceptions {
    @ExceptionHandler(AccountException.class)
    ResponseEntity<UniversalResponse> accountIsEmpty(AccountException e){
        return ResponseEntity.ok().body(UniversalResponse.builder().status(404).message(e.getMessage()).build());

    }
//    @ExceptionHandler(CustomerException.class)
//    ResponseEntity<UniversalResponse> customerIsEmpty(CustomerException e){
//        return ResponseEntity.ok().body(UniversalResponse.builder().status(404).message(e.getMessage()).build());
//    }
}
