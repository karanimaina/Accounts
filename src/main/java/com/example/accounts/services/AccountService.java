package com.example.accounts.services;

import com.example.accounts.Dto.AccountDto;
import com.example.accounts.exceptions.AccountException;
import com.example.accounts.model.Account;
import com.example.accounts.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    public Account addAccount(AccountDto accountDto, long customerId){
        Account account = accountRepository.findAccountByAccountNumber(accountDto.getAccountNumber());
        if (account!= null){
            throw  new AccountException("one of the values is null");
        }
        Account account1 = new Account();
        account1.setAccountNumber(accountDto.getBranchAddress());
        account1.setCustomerId(customerId);
        account1.setType(accountDto.getType());
        account1.setBranchAddress(accountDto.getBranchAddress());
        account1.setCreateDt(accountDto.getCreatdate());
        accountRepository.save(account1);
        return account1;
    }
    public List<Account>getAccount(){
        return accountRepository.findAll();
    }
}
