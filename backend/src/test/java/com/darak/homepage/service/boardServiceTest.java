package com.darak.homepage.service;

import com.darak.homepage.domain.Board;
import com.darak.homepage.dto.BoardDto;
import com.darak.homepage.repository.BoardRepository.BoardRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class boardServiceTest {
    @Autowired BoardService boardService;
    @Autowired BoardRepository boardRepository;

    @Test
    public void registerArticle(){
        BoardDto boardDto = new BoardDto();
        long id = 1;
        String writer = "yu";
        String title = "testtitle";
        String boardCat = "free";
        String content = "testcontent";
        long like = 0;

        boardDto.setArticleId(id);
        boardDto.setBoardCategory(boardCat);
        boardDto.setContent(content);
        boardDto.setLikes(like);
        boardDto.setTitle(title);
        boardDto.setWriter(writer);

        Board test = new Board();
        test.setArticleId(id);
        test.setBoardCategory(boardCat);
        test.setContent(content);
        test.setLike(like);
        test.setTitle(title);
        test.setWriter(writer);

        Board result = boardService.registerArticle(boardDto);

        Assertions.assertThat(result).isEqualTo(test);
    }
}
