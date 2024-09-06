package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Boolean existsByUsername(String username);

    @Query("select * from account where username = :user and password = :pass")
    public Optional<Account> getByUserAndPass(@Param("user") String user, @Param("pass") String pass);
}
