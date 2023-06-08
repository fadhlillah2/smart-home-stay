package com.komodo.serviceone.controller;

import com.komodo.serviceone.entity.CheckOut;
import com.komodo.serviceone.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class CheckOutController {
    @Autowired
    private CheckOutService checkOutService;

    @PostMapping("/{checkInId}")
    public CheckOut checkOut(@PathVariable Long checkInId) {
        return checkOutService.checkOut(checkInId);
    }
}