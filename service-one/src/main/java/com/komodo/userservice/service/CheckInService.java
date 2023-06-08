package com.komodo.userservice.service;

import com.komodo.userservice.entity.CheckIn;
import com.komodo.userservice.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInService {
    @Autowired
    private CheckInRepository checkInRepository;

    public CheckIn checkIn(Long userId, Long roomId) {
        CheckIn checkIn = new CheckIn();
        checkIn.setUserId(userId);
        checkIn.setRoomId(roomId);
        return checkInRepository.save(checkIn);
    }
}