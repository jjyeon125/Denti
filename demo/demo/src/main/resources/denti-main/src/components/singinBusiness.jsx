import React, { useEffect } from 'react';
import DentiLogo from '../img/denti.png';
import './signin2.css';

function SignInBusiness() {
    useEffect(() =>{
        const agreeChkAll = document.querySelector('input[name=agreeAll]');
        agreeChkAll.addEventListener('change', (e) => {
        let agreeChk = document.querySelectorAll('input[name=agree]');
        for(let i = 0; i < agreeChk.length; i++){
            agreeChk[i].checked = e.target.checked;
        }
    });
    });
    
    return(
        <div className="container" id="singInContainer2">
            <div className='TopText'>회원가입</div>
            <img src={DentiLogo} alt="Logo" id='dentiLogo' />
            <form action="">
                <input type="text" placeholder='아이디' required/> <br/>
                <input type="password" placeholder='비밀번호' required/> <br/>
                <input type="email" placeholder='이메일' required/> <br/>
                <div className="agreeContainer">
                <label htmlFor='agreeAll'><span className='agreeAll'>아래 약관을 모두 동의합니다.</span><input type="checkbox" name='agreeAll' id='agreeAll' /></label> <br/>
                <label htmlFor="agree"><span className='agree'>이용약관 동의 (필수)</span><input type="checkbox" name="agree" value="1" required/></label> <br/>
                <label htmlFor="agree"><span className='agree'>개인정보 수집 이용 동의 (필수)</span><input type="checkbox" name="agree" value="2" required/></label> <br/>
                <label htmlFor="agree"><span className='agree'>혜택 | 이벤트 광고 수신 (선택)</span><input type="checkbox" name="agree" value="3" /></label> <br/>
                </div>
                <input type="submit" value="가입하기"/>
            
            </form>
        </div>
    )
}

export default SignInBusiness