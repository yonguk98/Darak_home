import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Test from './Test';
import { Cookies } from "react-cookie";

function Login() {
  const navigate = useNavigate();

  const navigateToJoin = () => {
    navigate("/user/join");
  };

  const navigateToTest = () => {
    navigate("/test");
  };

  const [formData, setFormData] = useState({
    id: "",
    pwd: "",
  });

  const [isLoggedIn, setIsLoggedIn] = useState(false);

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

      if (response.data === true) {
        setIsLoggedIn(true);
        // alert(document.cookie);
        navigateToTest(); // 로그인 성공 시, test 페이지로 이동
      }
    } catch (error) {
      console.error("서버 요청 오류: ", error);
    }
  };

  const loginFormView = (
    <div className="login-form">
      <p>Welcome!</p>
      <p>
        <input
          className="login-input"
          type="text"
          name="id"
          placeholder="아이디"
          value={formData.id}
          onChange={handleChange}
        />
      </p>
      <p>
        <input
          className="login-input"
          type="password"
          name="pwd"
          placeholder="비밀번호"
          value={formData.pwd}
          onChange={handleChange}
        />
      </p>
      <p>
        <button className="btn" onClick={handleSubmit}>
          로그인
        </button>
      </p>
    </div>
  );

  return (
    <div className="login">
      {isLoggedIn ? (
        <Test id={formData.id} />
      ) : (
        <>
          {loginFormView}
          <div className="signin">
            <p>
              계정이 없으신가요? <button onClick={navigateToJoin}>회원가입</button>
            </p>
          </div>
        </>
      )}
    </div>
  );
}

export default Login;
