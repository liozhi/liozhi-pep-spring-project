package com.example.service;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@Transactional
@Service
public class AccountService {
    AccountRepository accRepo;

    @Autowired
    public AccountService(AccountRepository accRepo){
        this.accRepo = accRepo;
    }

    public ResponseEntity<Account> createAccount(Account acc) {
        if (!accRepo.existsByUsername(acc.getUsername())) return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        if (acc.getUsername().length() > 0 && acc.getPassword().length() >= 4) {
            Account newAcc = accRepo.save(acc);
            return new ResponseEntity<>(newAcc, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Account> login(Account acc) {
        Optional<Account> optAcc = accRepo.getByUserAndPass(acc.getUsername(), acc.getPassword());
        if (optAcc.isPresent()) {
            Account loginAcc = optAcc.get();
            return new ResponseEntity<>(loginAcc, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
