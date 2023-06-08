package com.komodo.userservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name="rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type; // Single, Twin, Deluxe, Family, etc.
    private boolean isBooked;
    private double price;
    // getters and setters
}
