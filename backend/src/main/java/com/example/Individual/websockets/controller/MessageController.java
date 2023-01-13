package com.example.Individual.websockets.controller;

import com.example.Individual.websockets.entities.GreetingResponse;
import com.example.Individual.websockets.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@CrossOrigin(origins = "http://localhost:3000/ws")
@Controller
public class MessageController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GreetingResponse greeting(Message message) throws Exception {
        return new GreetingResponse(HtmlUtils.htmlEscape(message.getName()));
    }
}
