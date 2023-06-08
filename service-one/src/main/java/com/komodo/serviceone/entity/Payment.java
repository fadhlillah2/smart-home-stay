package com.komodo.serviceone.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long checkInId;
    private double amount;
    private LocalDateTime paymentTime = LocalDateTime.now();
    // getters and setters
}
