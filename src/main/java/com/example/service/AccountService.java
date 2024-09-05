package com.example.service;


import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AccountService {
    AccountRepository accRepo;

    @Autowired
    public AccountService(AccountRepository accRepo){
        this.accRepo = accRepo;
    }

    public Account createAccount(Account acc) {
        if (acc.getUsername().length() > 0 &&!accRepo.existsByUsername(acc.getUsername()) && acc.getPassword().length() >= 4) {
            return accRepo.save(acc);
        }
        return null;
    }

    public Account login(Account acc) {
        Optional<Account> optAcc = accRepo.getByUserAndPass(acc.getUsername(), acc.getPassword());
        if (optAcc.isPresent()) {
            return optAcc.get();
        }
        return null;
    }
}
