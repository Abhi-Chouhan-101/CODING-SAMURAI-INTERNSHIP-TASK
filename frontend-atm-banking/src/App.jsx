import React, { useEffect, useState } from 'react';
import { Routes, Route, Navigate, useLocation } from 'react-router-dom';
import Login from './pages/Login';
import Register from './pages/Register';
import Dashboard from './pages/Dashboard';
import Deposit from './pages/Deposit';
import Withdraw from './pages/Withdraw';
import Transactions from './pages/Transactions';
import Navbar from './components/Navbar';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem('token'));
  const location = useLocation();

  useEffect(() => {
    setIsLoggedIn(!!localStorage.getItem('token'));
  }, [location.pathname]); // 🔁 Re-run on route change

  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={!isLoggedIn ? <Login /> : <Navigate to="/dashboard" />} />
        <Route path="/register" element={!isLoggedIn ? <Register /> : <Navigate to="/dashboard" />} />
        <Route path="/dashboard" element={isLoggedIn ? <Dashboard /> : <Navigate to="/" />} />
        <Route path="/deposit" element={isLoggedIn ? <Deposit /> : <Navigate to="/" />} />
        <Route path="/withdraw" element={isLoggedIn ? <Withdraw /> : <Navigate to="/" />} />
        <Route path="/transactions" element={isLoggedIn ? <Transactions /> : <Navigate to="/" />} />
      </Routes>
    </>
  );
}

export default App;
