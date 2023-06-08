package com.komodo.userservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventHandler {
    @KafkaListener(topics = {"user.register", "room.booked", "payment.received"})
    public void handleEvent(String message) {
        System.out.println(message);
    }
}
