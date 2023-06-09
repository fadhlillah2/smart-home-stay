// RegistrationForm.js
import React, { useState } from 'react';

const RegistrationForm = ({ onRegister }) => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();

    // Call the API to register the user
    // This is just a placeholder, you should replace it with actual API call
    console.log('Registering user with name:', name, 'and email:', email);

    // After the user is registered, call onRegister
    onRegister();
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Register</h2>
      <label>
        Name:
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
      </label>
      <label>
        Email:
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
      </label>
      <input type="submit" value="Register" />
    </form>
  );
};

export default RegistrationForm;
