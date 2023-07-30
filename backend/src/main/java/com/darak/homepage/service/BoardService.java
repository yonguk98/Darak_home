package com.darak.homepage.service;

import com.darak.homepage.domain.Board;
import com.darak.homepage.dto.BoardDto;
import com.darak.homepage.repository.BoardRepository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }
    //글 등록
    public Board registerArticle(BoardDto boardDto){
        Board board = new Board();
        board.setBoardCategory(boardDto.getBoardCategory());
        board.setWriter(boardDto.getWriter());
        board.setContent(boardDto.getContent());
        board.setLike(boardDto.getLikes());
        board.setTitle(boardDto.getTitle());
        board.setRegDate(boardDto.getRegDate());
        boardRepository.save(board);

        return board;
    }
    //글 삭제
    //글 수정

}
