package com.example.whatsapp_chatbot.controller;

import com.example.whatsapp_chatbot.model.MessageRequest;
import com.example.whatsapp_chatbot.model.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;;

@RestController
public class WebhookController {
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);
    @PostMapping
    public MessageResponse recieveMessage(@RequestBody MessageRequest request){
        String incomingMessage = request.getMessage();

        logger.info("Recieved WhatsApp message:{}", incomingMessage);

        String reply;

        if (incomingMessage == null){
            reply = "Please send a valid message";
        }else {
            switch ( incomingMessage.trim().toLowerCase()){
                case "hi":
                    reply = "Hello";
                    break;
                case "bye":
                    reply = "Goodbye";
                default:
                    reply = "I don't understand the message";
            }
        }
        return new MessageResponse(reply);
    }
}
