import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './Dashboard.css';

const Register = () => {
  const [form, setForm] = useState({
    fullName: '',
    email: '',
    pin: '',
    accountNumber: '',
    accountType: 'SAVING',
    address: '',
    role: 'ROLE_CUSTOMER',
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleRegister = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8083/api/users/register', form);
      alert('✅ Registration successful. Please login.');
      navigate('/');
    } catch (error) {
      alert('❌ Registration failed. Try different account number.');
    }
  };

  return (
    <div className="dashboard-container">
      <h2>Register</h2>
      <form onSubmit={handleRegister}>
        <input name="fullName" type="text" placeholder="Full Name" value={form.fullName} onChange={handleChange} required />
        <input name="email" type="email" placeholder="Email" value={form.email} onChange={handleChange} required />
        <input name="accountNumber" type="text" placeholder="Account Number" value={form.accountNumber} onChange={handleChange} required />
        <input name="pin" type="password" placeholder="PIN" value={form.pin} onChange={handleChange} required />
        <select name="accountType" value={form.accountType} onChange={handleChange}>
          <option value="SAVING">Saving</option>
          <option value="CURRENT">Current</option>
        </select>
        <input name="address" type="text" placeholder="Address" value={form.address} onChange={handleChange} required />
        <select name="role" value={form.role} onChange={handleChange}>
          <option value="ROLE_CUSTOMER">Customer</option>
          <option value="ROLE_ADMIN">Admin</option>
        </select>
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default Register;
