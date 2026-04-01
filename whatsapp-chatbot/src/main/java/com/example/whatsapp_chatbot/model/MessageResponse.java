package com.example.whatsapp_chatbot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class MessageResponse {
    @Getter@Setter
    private String reply;
    public MessageResponse(String reply){
        this.reply = reply;
    }
}
