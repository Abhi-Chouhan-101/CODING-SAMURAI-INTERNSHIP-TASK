import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './Dashboard.css';

const Transactions = () => {
  const [transactions, setTransactions] = useState([]);
 
const formatDateTime = (dateTimeString) => {
  if (!dateTimeString) return 'N/A';
  
  // Remove microseconds (after dot)
  const cleaned = dateTimeString.split('.')[0]; // "2025-07-17T13:03:03"

  // Convert to Date
  const date = new Date(cleaned);

  // Return in readable format
  return isNaN(date) ? 'Invalid' : date.toLocaleString('en-IN'); 
};

  useEffect(() => {
    const fetchTransactions = async () => {
      const token = localStorage.getItem('token');
      try {
        const res = await axios.get('http://localhost:8083/api/account/transactions', {
          headers: { Authorization: `Bearer ${token}` },
        });
        setTransactions(res.data);
      } catch (err) {
        alert('❌ Failed to load transactions.');
      }
    };
    fetchTransactions();
  }, []);

  return (
    <div className="dashboard-container">
      <h2>Transaction History</h2>
      <table>
        <thead>
          <tr>
            <th>Type</th>
            <th>Amount</th>
            <th>Balance</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          {transactions.map((txn, index) => (
            <tr key={index}>
              <td>{txn.type}</td>
              <td>₹ {txn.amount}</td>
              <td>₹ {txn.postBalance}</td>
               <td>{formatDateTime(txn.transactionTime)}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Transactions;
