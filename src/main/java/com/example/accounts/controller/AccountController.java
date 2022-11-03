package com.example.accounts.controller;

import com.example.accounts.Dto.AccountDto;
import com.example.accounts.commons.UniversalResponse;
import com.example.accounts.model.Account;
import com.example.accounts.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/add/account/{customerId}")
    ResponseEntity<UniversalResponse>addAccount(@RequestBody AccountDto accountDto,@PathVariable("customerId")long customerId){
       Account account = accountService.addAccount(accountDto,customerId);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        return ResponseEntity.created(location).body(UniversalResponse.builder().status(201).data(account).message("account created successfully").build());
    }

    @GetMapping("/get/account")
    ResponseEntity<UniversalResponse>getAccount(){
        List<Account> accountList = accountService.getAccount();
        return  ResponseEntity.ok().body(UniversalResponse.builder().data(accountList).status(200).message("account retrieved").build());

    }
}
