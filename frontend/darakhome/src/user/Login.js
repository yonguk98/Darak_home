import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from 'react-router-dom';

function Login(props) {

    const navigate = useNavigate();

    const navigateToWrite = () => {
        navigate("/user/join");
    };


    const [formData, setFormData] = useState({
        id: "",
        pwd: "",
      });
    
      const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
      };
    
      const handleSubmit = async (e) => {
        e.preventDefault();
        try {
          const serverUrl = "http://localhost:8080/users/login";
    
          const response = await axios.post(serverUrl, formData);
    
          console.log("서버 응답: ", response.data);
        } catch (error) {
          console.error("서버 요청 오류: ", error);
        }
      };

    return (
        <div className="login">
            <div className="login-form">
                <p>Welcome!</p>
                <p><input className="login-input" type="text" name="id" placeholder="아이디" value={formData.id} onChange={handleChange} /></p>
                <p><input className="login-input" type="password" name="pwd" placeholder="비밀번호" value={formData.pwd} onChange={handleChange} /></p>
                <p><button className="btn" onClick={handleSubmit}>로그인</button></p>
            </div>
            <div className="signin">
                <p>계정이 없으신가요?   <button onClick={navigateToWrite}>회원가입</button></p>
            </div>
        </div>
        
    );
}

export default Login;