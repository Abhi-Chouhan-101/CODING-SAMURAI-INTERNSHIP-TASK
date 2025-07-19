import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './Dashboard.css';

const Login = () => {
  const [accountNumber, setAccountNumber] = useState('');
  const [pin, setPin] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8083/api/users/login', {
        accountNumber,
        pin,
      });

      localStorage.setItem('token', response.data.token);
      alert('✅ Login successful');
      navigate('/dashboard');
    } catch (error) {
      alert('❌ Login failed. Check account number or PIN.');
    }
  };

  return (
    <div className="dashboard-container">
      <h2>ATM Login</h2>
      <form onSubmit={handleLogin}>
        <input
          type="text"
          placeholder="Account Number"
          value={accountNumber}
          onChange={(e) => setAccountNumber(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="PIN"
          value={pin}
          onChange={(e) => setPin(e.target.value)}
          required
        />
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
