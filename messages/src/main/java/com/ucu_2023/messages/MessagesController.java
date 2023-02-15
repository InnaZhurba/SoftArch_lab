package com.ucu_2023.messages;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesController {

    // Static message for GET request
    @GetMapping("/messages")
    public String listMessages(){
        return "messages-service is not implemented yet";
    }
}
