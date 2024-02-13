package com.example.demo.qualifier;

public class EmailService implements MessageService{

    public void sendMsg(String message) {
         System.out.println(message);
    }
}