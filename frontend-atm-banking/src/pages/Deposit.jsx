import React, { useState } from 'react';
import axios from 'axios';
import './Dashboard.css';

const Deposit = () => {
  const [amount, setAmount] = useState('');

  const handleDeposit = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem('token');
    try {
      await axios.post(`http://localhost:8083/api/account/deposit?amount=${amount}`, {}, {
        headers: { Authorization: `Bearer ${token}` },
      });
      alert(`✅ Deposited ₹${amount} successfully`);
      setAmount('');
    } catch (error) {
      alert('❌ Failed to deposit.');
    }
  };

  return (
    <div className="dashboard-container">
      <h2>Deposit Amount</h2>
      <form onSubmit={handleDeposit}>
        <input type="number" value={amount} onChange={(e) => setAmount(e.target.value)} placeholder="Enter amount" required />
        <button type="submit">Deposit</button>
      </form>
    </div>
  );
};

export default Deposit;
