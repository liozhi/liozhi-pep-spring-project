package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Account;
import com.example.entity.Message;

import com.example.service.AccountService;
import com.example.service.MessageService;

import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

import java.util.List;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocialMediaController {

    AccountService accserv;
    MessageService msgserv;

    @Autowired
    public SocialMediaController(AccountService as, MessageService ms) {
        this.accserv = as;
        this.msgserv = ms;
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public ResponseEntity<Account> register(@RequestBody Account acc) {
        ResponseEntity<Account> newacc = accserv.createAccount(acc);
        return newacc;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<Account> login(@RequestBody Account acc) {
        ResponseEntity<Account> loginAcc = accserv.login(acc);
        return loginAcc;
    }

    @PostMapping(value = "/messages")
    @ResponseBody
    public ResponseEntity<Message> createMessage(@RequestBody Message msg) {
        return null;
    }

    @GetMapping("/messages")
    @ResponseBody
    public ResponseEntity<List<Message>> getAllMessages() {
        return null;
    }
    
    @GetMapping("/messages/{id}")
    @ResponseBody
    public ResponseEntity<Message> getMessageById(@PathVariable("id") long id) {
        return null;
    }

    @DeleteMapping("/messages/{id}")
    @ResponseBody
    public ResponseEntity<Message> deleteMessageById(@PathVariable("id") long id) {
        return null;
    }

    @PatchMapping("/messages/{id}")
    @ResponseBody
    public ResponseEntity<Message> updateMessageById(@PathVariable("id") long id, @RequestBody Message msg) {
        return null;
    }

    @GetMapping("/accounts/{id}/messages")
    @ResponseBody
    public ResponseEntity<List<Message>> getAllMessagesByAccountId(@PathVariable("id") long id) {
        return null;
    }
}
