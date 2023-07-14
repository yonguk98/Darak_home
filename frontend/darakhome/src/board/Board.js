import React from "react";

function Board() {
    return (
        <div className="board">
            <div className="board-name">
                <h1>게시판입니다.</h1>
            </div>
            <div className="board-info">
                <a href="/board" className="board-info-name">
                    <strong>게시판 이름</strong>
                </a>
                n개의 글
            </div>
            <table className="board-table">
                <tr>
                    <th className="board-table-number">번호</th>
                    <th className="board-table-title">제목</th>
                    <th className="board-table-date">작성일</th>
                    <th className="board-table-view">조회수</th>
                </tr>
            </table>
        </div>
    );
}

export default Board;