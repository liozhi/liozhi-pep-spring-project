package com.example.service;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MessageService {
    MessageRepository msgRepo;
    AccountRepository accRepo;

    @Autowired
    public MessageService(MessageRepository msgRepo, AccountRepository accRepo){
        this.msgRepo = msgRepo;
        this.accRepo = accRepo;
    }

    public ResponseEntity<Message> addMessage(Message msg){
        Optional<Account> optAcc = accRepo.getByAccountId((long) msg.getPostedBy());
        if (!optAcc.isPresent()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        if (!(msg.getMessageText().length() > 0) || !(msg.getMessageText().length() < 255)) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        Message newMsg = msgRepo.save(msg);
        return new ResponseEntity<Message>(newMsg, HttpStatus.OK);
    }

    public List<Message> getAllMessages(){
        return msgRepo.findAll();
    }

    public Message getMessageById(long id) {
        Optional<Message> optMsg = msgRepo.getByMessageId(id);
        if (optMsg.isPresent()) {
            return optMsg.get();
        }
        return null;
    }

    public List<Message> getMessagesByUserId(long uid) {
        return msgRepo.getByUserId(uid);
    }

    public boolean deleteMessage(long id) {
        Optional<Message> optMsg = msgRepo.getByMessageId(id);
        if (optMsg.isPresent()) {
            msgRepo.deleteByMessageId(id);
            return true;
        }
        return false;
    }

    public boolean updateMessage(long id, String msgtxt) {
        if (msgtxt.length() <= 255 && msgtxt.length() > 0) {
            Optional<Message> optMsg = msgRepo.getByMessageId(id);
            if (optMsg.isPresent()) {
                Message msg = optMsg.get();
                msg.setMessageText(msgtxt);
                msgRepo.save(msg);
                return true;
            }
        }
        return false;
    }
}
