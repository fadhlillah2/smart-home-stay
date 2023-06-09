// App.js
import React, { useState } from 'react';
import RegistrationForm from './RegistrationForm';
import RoomList from './RoomList';
import BookingForm from './BookingForm';
import CheckoutForm from './CheckoutForm';
import PaymentForm from './PaymentForm';


const App = () => {
  const [isRegistered, setRegistered] = useState(false);
  const [rooms, setRooms] = useState([
    { id: '1', type: 'single', available: true },
    { id: '2', type: 'deluxe', available: true },
    // Add more rooms as needed
  ]);
  const [booking, setBooking] = useState(null);
  const [paymentDone, setPaymentDone] = useState(false);

  const handleRegister = () => {
    setRegistered(true);
  };

  const handleBook = (roomId, extras) => {
    // ... book the room as before

    // After the room is booked, update the booking state
    setBooking({ roomId, date: new Date(), extras });
  };

  const handleCheckout = () => {
    // After the user checks out, clear the booking state
    setBooking(null);
    setPaymentDone(false);
  };

  const handlePayment = () => {
    // After the payment is made, set paymentDone to true
    setPaymentDone(true);
  };

  return (
    <div>
      <h1>Welcome to Smart Home Stay</h1>
      {!isRegistered && <RegistrationForm onRegister={handleRegister} />}
      {isRegistered && !booking && (
        <>
          <RoomList rooms={rooms} />
          <BookingForm onBook={handleBook} />
        </>
      )}
      {booking && !paymentDone && (
        <>
          <CheckoutForm booking={booking} onCheckout={handleCheckout} />
          <PaymentForm onPayment={handlePayment} />
        </>
      )}
      {paymentDone && (
        <p>Payment successful. Thank you for choosing Smart Home Stay!</p>
      )}
    </div>
  );
}

export default App;
