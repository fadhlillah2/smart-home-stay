// RoomList.js
import React from 'react';

const RoomList = ({ rooms }) => {
  const handleBook = (roomId) => {
    // Call the API to book the room
    console.log('Booking room with ID:', roomId);

    // After the room is booked, update the local state
    // This is just a placeholder, you should replace it with actual state update after the booking is confirmed by the API
    alert(`Room ${roomId} is booked!`);
  };

  return (
    <div>
      <h2>Available Rooms</h2>
      <ul>
        {rooms.map((room) => (
          <li key={room.id}>
            {room.type} Room {room.id}
            {room.available && <button onClick={() => handleBook(room.id)}>Book</button>}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default RoomList;
