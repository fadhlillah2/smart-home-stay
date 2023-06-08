package com.komodo.userservice.service;

import com.komodo.userservice.entity.Facility;
import com.komodo.userservice.entity.Room;
import com.komodo.userservice.repository.FacilityRepository;
import com.komodo.userservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public List<Room> getAvailableRooms() {
        return roomRepository.findByIsBookedFalse();
    }

    public Room bookRoom(Long id, List<Long> facilityIds) {
        Room room = roomRepository.findById(id).orElseThrow(); // Throw an exception if the room doesn't exist
        room.setBooked(true);
        Room bookedRoom = roomRepository.save(room);

        double bill = room.getPrice();
        for (Long facilityId : facilityIds) {
            Facility facility = facilityRepository.findById(facilityId).orElseThrow();
            bill += facility.getCost();
        }
        kafkaTemplate.send("room.booked", "Room booked with id " + bookedRoom.getId() + ". Total cost: " + bill);

        return bookedRoom;
    }
}
