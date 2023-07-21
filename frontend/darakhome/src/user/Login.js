import React from "react";
import { useNavigate } from 'react-router-dom';

function Login(props) {

    const navigate = useNavigate();

    const navigateToWrite = () => {
        navigate("/user/join");
    };

    return (
        <div className="login">
            <div className="login-form">
                <p>Welcome!</p>
                <p><input className="login-input" type="text" name="username" placeholder="아이디" /></p>
                <p><input className="login-input" type="password" name="pwd" placeholder="비밀번호" /></p>

                <p><input className="btn" type="submit" value="로그인" /></p>
            </div>
            <div className="signin">
                <p>계정이 없으신가요?   <button onClick={navigateToWrite}>회원가입</button></p>
            </div>
        </div>
        
    );
}

export default Login;