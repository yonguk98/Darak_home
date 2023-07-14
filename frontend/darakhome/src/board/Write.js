import React from "react";

function Write() {
    return(
        <div className="content">
            <input className="content-title" type="text" name="title" placeholder="제목을 입력해주세요" />
            <input className="content-content" type="text" name="content" placeholder="내용을 입력해주세요" />
            <button>등록하기</button>
        </div>
    );
}

export default Write;