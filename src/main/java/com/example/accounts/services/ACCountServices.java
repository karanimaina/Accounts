package com.fortune.bank.service;

import com.example.accounts.Dto.AccountDto;
import com.example.accounts.model.Account;
import com.example.accounts.repo.AccountRepository;
import com.fortune.bank.Dto.AccountDto;
import com.fortune.bank.exceptions.AccountException;
import com.fortune.bank.model.Account;
import com.fortune.bank.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    public Account addAccount(AccountDto accountDto, long customerId){
        Account account = accountRepository.findAccountByAccountNumber(accountDto.getAccountNumber());
//         Customer customer = customerRepository.findById(accountDto.getCustomerId()).orElse(null);
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

//     public Customer addCustomer(CustomerDto customerDto){
//         Customer customer = customerRepository.findCustomerByUsername(customerDto.getUsername()).orElse(null);
//         if (customer==null){
//             Customer customer1 = new Customer();
//             customer1.setUsername(customerDto.getUsername());
//             customer1.setMobileNumber(customerDto.getMobileNumber());
//             customer1.setEmail(customerDto.getEmail());
//             customerRepository.save(customer1);
//             return customer1;
//         }
//         throw  new CustomerDoesNotExist("customer does not exist");
//     }

    //     public List<Customer> getCustomers (){
//         return customerRepository.findAll();
//     }
    public List<Account>getAccount(){
        return accountRepository.findAll();
    }
}
