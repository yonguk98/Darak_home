import React from "react";
import { useState } from "react";
import { useEffect } from "react";

function Login(props) {

    const [ id, setId ] = useState("");
    const [ password, setPassword ] = useState("");

    return (
        <div className="login">
            <div className="login-form">
                <p>Welcome!</p>
                <p><input className="login-input" type="text" name="username" placeholder="아이디" onChange={event => {
                    setId(event.target.value);
                }} /></p>
                <p><input className="login-input" type="password" name="pwd" placeholder="비밀번호" onChange={event => {
                    setPassword(event.target.value);
                }} /></p>

                <p><input className="btn" type="submit" value="로그인" /></p>
            </div>
            <div className="signin">
                <p>계정이 없으신가요?   <button>회원가입</button></p>
            </div>
        </div>
        
    );
}

export default Login;