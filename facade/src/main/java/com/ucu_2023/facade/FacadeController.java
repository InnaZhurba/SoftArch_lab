package com.ucu_2023.facade;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class FacadeController {
    // facade service send requests to logging and messages services
    // it get requests from client service like POST/GET

    // created WebClient`s for logging and messages services
    WebClient loggingClient = WebClient.create("http://localhost:8081");
    WebClient messagesClient = WebClient.create("http://localhost:8082");

    // Get request from client service
    // send GET request to logging service
    // send GET request to messages service
    @GetMapping("/facade_service")
    public String clientWebClient() {
        String cachedValues = loggingClient
                .get()
                .uri("/log")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        String messages = messagesClient
                .get()
                .uri("/messages")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return cachedValues + " : " + messages;
    }

    // Post request from client service
    // send POST request to logging service
    @PostMapping("/facade_service")
    public Void facadeWebClient(@RequestBody String message) {
        return loggingClient
                .post()
                .uri("/log")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(message)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
