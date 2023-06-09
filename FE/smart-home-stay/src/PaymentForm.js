// PaymentForm.js
import React from 'react';

const PaymentForm = ({ onPayment }) => {
  const handleSubmit = (event) => {
    event.preventDefault();

    // Call the API to process the payment
    console.log('Processing payment');

    // After the payment is processed, call onPayment
    onPayment();
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Payment</h2>
      <p>Please enter your payment information.</p>
      <label>
        Card number:
        <input type="text" />
      </label>
      <label>
        Expiry date:
        <input type="text" />
      </label>
      <label>
        CVV:
        <input type="text" />
      </label>
      <input type="submit" value="Pay" />
    </form>
  );
};

export default PaymentForm;
