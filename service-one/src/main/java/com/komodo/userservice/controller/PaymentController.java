package com.komodo.userservice.controller;

import com.komodo.userservice.entity.Payment;
import com.komodo.userservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/{checkInId}")
    public Payment makePayment(@PathVariable Long checkInId, @RequestBody double amount) {
        return paymentService.makePayment(checkInId, amount);
    }
}
