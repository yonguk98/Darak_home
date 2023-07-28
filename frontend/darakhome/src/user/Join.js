import React, { useState } from "react";
import axios from "axios";

function Join() {
  const [formData, setFormData] = useState({
    id: "",
    pwd: "",
    email: "",
    name: "",
    studentID: "",
    nickname: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const serverUrl = "http://localhost:8080/users/join";

      const response = await axios.post(serverUrl, formData);

      console.log("서버 응답: ", response.data);
    } catch (error) {
      console.error("서버 요청 오류: ", error);
    }
  };

  return (
    <article>
      <div className="join">
        <div className="join-content">
          <p>
            <input
              className="join-id"
              type="text"
              name="id"
              placeholder="아이디를 입력하세요."
              value={formData.id}
              onChange={handleChange}
            />
          </p>
          <p>
            <input
              className="join-pwd"
              type="password"
              name="pwd"
              placeholder="비밀번호를 입력하세요"
              value={formData.pwd}
              onChange={handleChange}
            />
          </p>
          <p>
            <input
              className="join-email"
              type="email"
              name="email"
              placeholder="이메일을 입력하세요."
              value={formData.email}
              onChange={handleChange}
            />
          </p>
          <p>
            <input
              className="join-name"
              type="text"
              name="name"
              placeholder="이름을 입력하세요."
              value={formData.name}
              onChange={handleChange}
            />
          </p>
          <p>
            <input
              className="join-studentID"
              type="number"
              name="studentID"
              placeholder="학번을 입력하세요."
              value={formData.studentID}
              onChange={handleChange}
            />
          </p>
          <p>
            <input
              className="join-nickname"
              type="text"
              name="nickname"
              placeholder="닉네임을 입력하세요."
              value={formData.nickname}
              onChange={handleChange}
            />
          </p>
        </div>
        <div className="join-button">
          <button onClick={handleSubmit}>회원가입</button>
        </div>
      </div>
    </article>
  );
}

export default Join;
