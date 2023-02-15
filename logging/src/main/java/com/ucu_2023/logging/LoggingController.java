package com.ucu_2023.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class LoggingController {
    // logging service save messages from facade service
    // send all messages if facade service send GET request

    // Logger as a logger factory for this class
    // log messages will be saved in logging-service.log file
    public Logger logger =  LoggerFactory.getLogger(LoggingController.class);

    // a map for messages and UUIDs
    // UUID is a unique identifier for each message
    public Map<UUID, String> messages = new HashMap<>();

    // Get request from facade service
    @GetMapping("/log")
    public String listLog(){return messages.values().toString();}

    // Post request from facade service
    @PostMapping("/log")
    public ResponseEntity<Void> log(@RequestBody String message){
        UUID uuid = UUID.randomUUID();
        messages.put(uuid, message);
        logger.info("Message logged: " + message);
        return ResponseEntity.ok().build();
    }
}
