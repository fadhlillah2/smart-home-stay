package com.komodo.serviceone.repository;

import com.komodo.serviceone.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByIsBookedFalse(); // Finds all unbooked rooms
}
