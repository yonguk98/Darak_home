import React from "react";

function Write() {
    return(
        <article className="post">
            <div className="post-title">
                <input className="post-title-input" type="text" name="title" placeholder="제목을 입력하세요." />
            </div>
            <div className="post-content">
                <input className="post-content-input" type="text" name="title" placeholder="내용을 입력하세요." />
            </div>
            <div className="post-btn">
                <button>등록하기</button>
            </div>
        </article>
    );
}

export default Write;