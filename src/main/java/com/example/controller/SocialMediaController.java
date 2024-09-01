package com.example.controller;

import com.example.entity.Account;
import com.example.entity.Message;

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

    @PostMapping(value = "/register")
    public ResponseEntity<Account> register(@RequestBody Account acc) {
        return null;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Account> login(@RequestBody Account acc) {
        return null;
    }

    @PostMapping(value = "/messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message msg) {
        return null;
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        return null;
    }
    
    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") long id) {
        return null;
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Message> deleteMessageById(@PathVariable("id") long id) {
        return null;
    }

    @PatchMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessageById(@PathVariable("id") long id, @RequestBody Message msg) {
        return null;
    }

    @GetMapping("/accounts/{id}/messages")
    public ResponseEntity<List<Message>> getAllMessagesByAccountId(@PathVariable("id") long id) {
        return null;
    }
}
