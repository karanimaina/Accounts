package com.example.accounts.controller;

import com.fortune.bank.Dto.AccountDto;
import com.fortune.bank.commons.UniversalResponse;
import com.fortune.bank.model.Account;
import com.fortune.bank.service.AccountService;
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

    @PostMapping("/add/account")
    ResponseEntity<UniversalResponse>addAccount(@RequestBody AccountDto accountDto){
       Account  account = accountService.addAccount(accountDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        return ResponseEntity.created(location).body(UniversalResponse.builder().status(201).data(account).message("account created successfully").build());
    }
//    @PostMapping("/add/customer")
//    ResponseEntity<UniversalResponse>addCustomer(@RequestBody CustomerDto customerDto){
//    Customer customer= accountService.addCustomer(customerDto);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(customer.getId())
//                .toUri();
//        return ResponseEntity.created(location).body(UniversalResponse.builder().status(201).data(customer).message("account created successfully").build());
//    }

    @GetMapping("/get/account")
    ResponseEntity<UniversalResponse>getAccount(){
        List<Account> accountList = accountService.getAccount();
        return  ResponseEntity.ok().body(UniversalResponse.builder().data(accountList).status(200).message("account retrieved").build());

    }
//    @GetMapping("/get/customers")
//    ResponseEntity<UniversalResponse>getCustomers(){
//        List<Customer> customerList = accountService.getCustomers();
//        return  ResponseEntity.ok().body(UniversalResponse.builder().data(customerList).status(200).message("customers retrieved").build());
//    }
}
