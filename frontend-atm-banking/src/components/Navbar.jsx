import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './Navbar.css';

const Navbar = () => {
  const navigate = useNavigate();
  const token = localStorage.getItem('token');

  const logout = () => {
    localStorage.removeItem('token');
    navigate('/');
  };

  return (
    <nav className="navbar">
      <h3 className="logo">ATM Banking</h3>
      <div className="nav-links">
        {!token ? (
          <>
            <Link to="/">🔐 Login</Link>
            <Link to="/register">🆕 Register</Link>
          </>
        ) : (
          <>
            <Link to="/dashboard">🏠 Dashboard</Link>
            <Link to="/deposit">💰 Deposit</Link>
            <Link to="/withdraw">💸 Withdraw</Link>
            <Link to="/transactions">📜 Transactions</Link>
            <button onClick={logout}>🚪 Logout</button>
          </>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
