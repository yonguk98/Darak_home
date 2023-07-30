package com.darak.homepage.service;

import com.darak.homepage.repository.MemberRepository.MemberRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class memberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void login(){
        String id = "yonguk";
        String password = "1234";

        boolean result = memberService.login(id,password);
        System.out.println(result);
        Assertions.assertThat(result).isEqualTo(true);
    }


}
