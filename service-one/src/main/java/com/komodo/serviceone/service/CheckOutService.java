package com.komodo.serviceone.service;

import com.komodo.serviceone.entity.CheckOut;
import com.komodo.serviceone.repository.CheckOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckOutService {
    @Autowired
    private CheckOutRepository checkOutRepository;

    public CheckOut checkOut(Long checkInId) {
        CheckOut checkOut = new CheckOut();
        checkOut.setCheckInId(checkInId);
        return checkOutRepository.save(checkOut);
    }
}