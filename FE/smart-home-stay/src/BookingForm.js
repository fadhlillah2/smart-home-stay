// BookingForm.js
import React, { useState } from 'react';

const BookingForm = ({ onBook }) => {
  const [roomId, setRoomId] = useState('');
  const [extras, setExtras] = useState({
    breakfast: false,
    extraBed: false,
  });
  const [error, setError] = useState(''); 

  const handleCheckboxChange = (event) => {
    setExtras({
      ...extras,
      [event.target.name]: event.target.checked,
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    if(roomId === '') { // Check if Room ID is not empty
      setError('Room ID cannot be empty.');
      return;
    }
    setError('');
    onBook(roomId, extras);
    setRoomId(''); // Clear the Room ID field after successful booking
    setExtras({ // Reset the extras
      breakfast: false,
      extraBed: false,
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Book a Room</h2>
      {error && <p style={{ color: 'red' }}>{error}</p>} {/* Display error message */}
      <label>
        Room ID:
        <input type="text" value={roomId} onChange={(e) => setRoomId(e.target.value)} required />
      </label>
      <label>
        Breakfast:
        <input type="checkbox" name="breakfast" checked={extras.breakfast} onChange={handleCheckboxChange} />
      </label>
      <label>
        Extra bed:
        <input type="checkbox" name="extraBed" checked={extras.extraBed} onChange={handleCheckboxChange} />
      </label>
      <input type="submit" value="Book Room" />
    </form>
  );
};

export default BookingForm;
