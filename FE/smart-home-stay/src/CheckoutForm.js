// CheckoutForm.js
import React from 'react';

const CheckoutForm = ({ booking, onCheckout }) => {
  const handleSubmit = (event) => {
    event.preventDefault();

    // Call the API to checkout the room and make the payment
    console.log('Checking out room with ID:', booking.roomId);

    // After the user checks out, call onCheckout
    onCheckout();
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Checkout</h2>
      <p>You booked room {booking.roomId} on {booking.date.toDateString()}.</p>
      <p>Extras:</p>
      <ul>
        {booking.extras.breakfast && <li>Breakfast</li>}
        {booking.extras.extraBed && <li>Extra bed</li>}
      </ul>
      <input type="submit" value="Checkout" />
    </form>
  );
};

export default CheckoutForm;
