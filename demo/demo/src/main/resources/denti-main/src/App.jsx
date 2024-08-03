import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Login from './components/login.jsx'
import Signin from './components/signin.jsx'
import SignInPersonal from './components/singinPersonal.jsx'
import SignInBusiness from './components/singinBusiness.jsx'
import { Routes, Route, BrowserRouter } from "react-router-dom";

function App() {

  return (
    <div className='container'>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/signin" element={<Signin />} />
          <Route path="/signin/personal" element={<SignInPersonal />} />
          <Route path="/signin/business" element={<SignInBusiness />} />
        </Routes>
      </BrowserRouter>
    </div>
    
  )
}

export default App
