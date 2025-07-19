import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Dashboard.css';

const Dashboard = () => {
  const [balance, setBalance] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchBalance = async () => {
      const token = localStorage.getItem('token');
      try {
        const res = await axios.get('http://localhost:8083/api/account/balance', {
          headers: { Authorization: `Bearer ${token}` },
        });
        setBalance(res.data);
      } catch (err) {
        alert('❌ Failed to fetch balance.');
        navigate('/');
      }
    };
    fetchBalance();
  }, [navigate]);

  return (
    <div className="dashboard-container">
      <h2>ATM Dashboard</h2>
      <h3>Current Balance: ₹ {balance !== null ? balance : 'Loading...'}</h3>
      <button onClick={() => navigate('/deposit')}>Deposit</button>
      <button onClick={() => navigate('/withdraw')}>Withdraw</button>
      <button onClick={() => navigate('/transactions')}>Transactions</button>
    </div>
  );
};

export default Dashboard;
