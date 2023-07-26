package com.darak.homepage.repository;

import com.darak.homepage.domain.Users;
import com.darak.homepage.service.MemberService;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class JpaMemberRepositoryTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void save(){
        Users users = new Users();
        long a = 1;
        users.setIdentity(a);
        users.setId("4");
        users.setPassword("1234");
        users.setName("1");

        Long saveIdentity = memberService.join(users);

        Users findUsers = memberService.findOne(saveIdentity).get();
        Assertions.assertThat(users.getName()).isEqualTo(findUsers.getName());
    }
}
