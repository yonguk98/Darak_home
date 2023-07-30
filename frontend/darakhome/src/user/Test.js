import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Cookies } from "react-cookie";

function Test() {
  const navigate = useNavigate();
  const [userId, setUserId] = useState(null);

  const handleLogout = () => {
    navigate("/");
  };

  useEffect(() => {
    // 쿠키를 파싱하여 userId 정보를 얻습니다.
    const cookies = document.cookie.split("; ");
    let userIdValue = null;
    for (const cookie of cookies) {
      const [name, value] = cookie.split("=");
      if (name === "userId") {
        userIdValue = true;
        userId = value;
        break;
      }
    }

    if (userIdValue) {
      // userId 정보를 설정합니다.
      setUserId(userId);
    }
  }, []);

  return (
    <div>
      <h1>Test 페이지</h1>
      {/* userId 정보를 출력합니다. */}
      {userId ? <p>userId: {userId}</p> : <p>userId 정보를 찾을 수 없습니다.</p>}
      <button onClick={handleLogout}>로그아웃</button>
    </div>
  );
}

export default Test;

