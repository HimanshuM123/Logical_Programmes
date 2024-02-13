package com.example.demo.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageProcessorImpl implements MessageProcessor {

    private MessageService messageService;

    // setter based DI
    @Autowired
    @Qualifier("twitterService")
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
 
    // constructor based DI
    @Autowired
    public MessageProcessorImpl(@Qualifier("twitterService") MessageService messageService) {
        this.messageService = messageService;
    }
 
    public void processMsg(String message) {
        messageService.sendMsg(message);
    }
}