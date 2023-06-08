package com.komodo.serviceone.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long roomId;
    private LocalDateTime checkInTime = LocalDateTime.now();
    // getters and setters
}