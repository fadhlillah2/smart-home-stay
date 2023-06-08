package com.komodo.userservice.controller;

import com.komodo.userservice.entity.CheckIn;
import com.komodo.userservice.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkin")
public class CheckInController {
    @Autowired
    private CheckInService checkInService;

    @PostMapping("/{userId}/{roomId}")
    public CheckIn checkIn(@PathVariable Long userId, @PathVariable Long roomId) {
        return checkInService.checkIn(userId, roomId);
    }
}