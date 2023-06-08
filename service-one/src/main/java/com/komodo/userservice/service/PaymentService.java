package com.komodo.userservice.service;

import com.komodo.userservice.entity.Payment;
import com.komodo.userservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Payment makePayment(Long checkInId, double amount) {
        Payment payment = new Payment();
        payment.setCheckInId(checkInId);
        payment.setAmount(amount);
        Payment savedPayment = paymentRepository.save(payment);
        kafkaTemplate.send("payment.received", "Payment received for check-in " + checkInId + ". Amount: " + amount);
        return savedPayment;
    }
}
