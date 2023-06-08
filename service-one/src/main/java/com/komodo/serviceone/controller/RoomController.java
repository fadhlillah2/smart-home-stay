package com.komodo.serviceone.controller;

import com.komodo.serviceone.entity.Room;
import com.komodo.serviceone.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    @PostMapping("/book/{id}")
    public Room bookRoom(@PathVariable Long id, @RequestBody List<Long> facilityIds) {
        return roomService.bookRoom(id, facilityIds);
    }
}
