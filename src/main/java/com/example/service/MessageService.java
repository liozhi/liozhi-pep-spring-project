package com.example.service;


import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Message getMessageById(long id) {
        Optional<Message> optMsg = msgRepo.findById(id);
        if (optMsg.isPresent()) {
            return optMsg.get();
        }
        return null;
    }

    public List<Message> getMessagesByUserId(long uid) {
        return msgRepo.getByUserId(uid);
    }

    public boolean deleteMessage(long id) {
        Optional<Message> optMsg = msgRepo.findById(id);
        if (optMsg.isPresent()) {
            msgRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateMessage(long id, String msgtxt) {
        if (msgtxt.length() <= 255 && msgtxt.length() > 0) {
            Optional<Message> optMsg = msgRepo.findById(id);
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
