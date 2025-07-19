import React, { useState } from 'react';
import axios from 'axios';
import './Dashboard.css';

const Withdraw = () => {
  const [amount, setAmount] = useState('');

  const handleWithdraw = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem('token');
    try {
      await axios.post(`http://localhost:8083/api/account/withdraw?amount=${amount}`, {}, {
        headers: { Authorization: `Bearer ${token}` },
      });
      alert(`✅ Withdrawn ₹${amount} successfully`);
      setAmount('');
    } catch (error) {
      alert('❌ Failed to withdraw.');
    }
  };

  return (
    <div className="dashboard-container">
      <h2>Withdraw Amount</h2>
      <form onSubmit={handleWithdraw}>
        <input type="number" value={amount} onChange={(e) => setAmount(e.target.value)} placeholder="Enter amount" required />
        <button type="submit">Withdraw</button>
      </form>
    </div>
  );
};

export default Withdraw;
