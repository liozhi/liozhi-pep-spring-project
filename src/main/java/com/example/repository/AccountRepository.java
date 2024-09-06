package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Boolean existsByUsername(String username);

    @Query(value = "select * from account where username = ?1 and password = ?2", nativeQuery = true)
    Optional<Account> getByUserAndPass(String user, String pass);
    
    @Query(value = "select * from account where accountId = ?1", nativeQuery = true)
    Optional<Account> getByAccountId(long id);
}