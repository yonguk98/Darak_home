package com.darak.homepage.controller;

import com.darak.homepage.dto.BoardDto;
import com.darak.homepage.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
    private final BoardService boardService;
    private final HttpServletResponse response;
    private final HttpServletRequest request;

    @Autowired
    public BoardController(BoardService boardService, HttpServletResponse response, HttpServletRequest request){
        this.boardService = boardService;
        this.response = response;
        this.request = request;
    }

    @ResponseBody
    @PostMapping("/board/register")
    public void register(@RequestParam BoardDto boardDto){
        boardService.registerArticle(boardDto);
    }
}
