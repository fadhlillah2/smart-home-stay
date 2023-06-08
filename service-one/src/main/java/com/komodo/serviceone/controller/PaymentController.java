package com.komodo.serviceone.controller;

import com.komodo.serviceone.entity.Payment;
import com.komodo.serviceone.service.PaymentService;
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
