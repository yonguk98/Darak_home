import React from "react";

function Join() {
    return (
        <article>
            <div className="join">
                <div className="join-content">
                    <p><input className="join-id" type="text" name="id" placeholder="아이디를 입력하세요." /></p>
                    <p><input className="join-pwd" type="password" name="pwd" placeholder="비밀번호를 입력하세요" /></p>
                    <p><input className="join-email" type="email" name="email" placeholder="이메일을 입력하세요." /></p>
                    <p><input className="join-name" type="name" name="name" placeholder="이름을 입력하세요." /></p>
                    <p><input className="join-studentID" type="number" name="studentID" placeholder="학번을 입력하세요." /></p>
                    <p><input className="join-nickname" type="nickname" name="nickname" placeholder="닉네임을 입력하세요." /></p>
                </div>
            </div>
        </article>
    );
}

export default Join;