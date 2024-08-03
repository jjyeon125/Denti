import React from 'react';
import DentiLogo from '../img/denti.png';
import PersonalIcon from '../img/personal-icon.png';
import BusinessIcon from '../img/business-icon.png';
import { Link } from 'react-router-dom';
import './signin.css';

function Signin(){
    return(
        <div className='container' id='SignInContainer'>
            <div className='TopText'>회원가입</div>
            <img src={DentiLogo} alt="Logo" id='dentiLogo' />
            <div className="signinOptionContainer">
                <div className="personalSignIn">
                    <img src={PersonalIcon} alt="" />
                    <p className='SignInTitle'>개인회원</p>
                    <p className='SignInEx'>치료를 원하는 회원</p>
                    <Link to="/signin/personal">개인회원 가입하기</Link>
                </div>
                <div className="businessSignIn">
                    <img src={BusinessIcon} alt="" />
                    <p className='SignInTitle'>기업회원</p>
                    <p className='SignInEx'>서비스 제공을 원하는 병원</p>
                    <Link to="/signin/business">기업회원 가입하기</Link>
                </div>
            </div>
        </div>
    )
}

export default Signin