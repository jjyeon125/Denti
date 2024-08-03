import React, { useState } from 'react';
import DentiLogo from '../img/denti.png';
import kakao from '../img/kakao.png';
import naver from '../img/naver.png';
import google from '../img/google.png';
import apple from '../img/apple.png';
import { Link } from 'react-router-dom';
import './login.css';

function Login() {
    const [LoginType, setLoginType] = useState("Personal");
    let content = null;

    if(LoginType === "Personal"){
        content = <>
        <div className='loginFormContainer'>
            <form action="">
                <input type="text" placeholder='아이디'/> <br/>
                <input type="password" placeholder='비밀번호'/> <br/>
                <input type="checkbox" name="" id="AutoLogin" /> <label htmlFor='AutoLogin'>자동로그인</label> <br/>
                <input type="submit" onClick={event=>{event.preventDefault();}} value='개인회원 로그인'/> <br/>
            </form>
            <div className='loginMenu'>
                <a href="">아이디 찾기</a><span>|</span>
                <a href="">비밀번호 찾기</a><span>|</span>
                <Link to="/signin">회원가입</Link>
            </div>
        </div>
        <div className='socialLogin'>
            <p>sns계정으로 로그인하기</p>
            <div className="socialLoginIcon">
            <a href=""><img src={kakao} alt="" /></a>
            <a href=""><img src={naver} alt="" /></a>
            <a href=""><img src={google} alt="" /></a>
            <a href=""><img src={apple} alt="" /></a>
            </div>
        </div>
        </>
    } else if(LoginType === "Business"){
        content = <>
        <div className='loginFormContainer'>
            <form action="">
                <input type="text" placeholder='아이디'/> <br/>
                <input type="password" placeholder='비밀번호'/> <br/>
                <input type="checkbox" name="" id="AutoLogin" /> <label htmlFor='AutoLogin'>자동로그인</label> <br/>
                <input type="submit" onClick={event=>{event.preventDefault();}} value='기업회원 로그인'/> <br/>
            </form>
            <div className='loginMenu'>
                <a href="">아이디 찾기</a><span>|</span>
                <a href="">비밀번호 찾기</a><span>|</span>
                <Link to="/signin">회원가입</Link>
            </div>
        </div>
        </>
    }
    return (
        <div className='container' id='LoginContainer'>
            <div className='TopText'>로그인</div>
            <img src={DentiLogo} alt="Logo" id='dentiLogo'/>
            <div className='LoginTypeContainer'>
                <input type="radio" name='LoginType' defaultChecked className='btn' id='personalBtn' onClick={()=>{setLoginType("Personal")}}/><label htmlFor="personalBtn">개인회원</label>
                <input type="radio" name='LoginType' className='btn' id='BusinessBtn' onClick={()=>{setLoginType("Business")}}/><label htmlFor="BusinessBtn">기업회원</label>
            </div>
            {content}
        </div>
    )
}

export default Login
