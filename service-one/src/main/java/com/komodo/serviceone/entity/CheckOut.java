package com.komodo.serviceone.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class CheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long checkInId;
    private LocalDateTime checkOutTime = LocalDateTime.now();
    // getters and setters
}