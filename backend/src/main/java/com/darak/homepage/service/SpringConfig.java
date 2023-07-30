package com.darak.homepage.service;

import com.darak.homepage.repository.BoardRepository.BoardRepository;
import com.darak.homepage.repository.MemberRepository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository, BoardRepository boardRepository){
        this.memberRepository = memberRepository;
        this.boardRepository = boardRepository;
    }

    @Bean
    public MemberService memberService(){return new MemberService(memberRepository);}

    @Bean
    public BoardService boardService(){return new BoardService(boardRepository);}

}
