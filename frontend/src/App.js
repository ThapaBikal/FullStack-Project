import React, { useState } from 'react';
import { Route } from 'react-router-dom';
import './App.css';
import LoginForm from './components/loginForm';
import Navbar from './components/navbar';
import SignupForm from './components/signupForm';

function App() {
  return (
    <div>
      <Navbar />
      <main className="container">
        <Route path="/login" component={LoginForm} />
        <Route path="/signup" component={SignupForm} />

      </main>
    </div>
  );
}

export default App;
