package com.example.service;


import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageService {
    MessageRepository msgRepo;

    @Autowired
    public MessageService(MessageRepository msgRepo){
        this.msgRepo = msgRepo;
    }

    public Message addMessage(Message msg){
        return msgRepo.save(msg);
    }

    public List<Message> getAllMessages(){
        return msgRepo.findAll();
    }
}
