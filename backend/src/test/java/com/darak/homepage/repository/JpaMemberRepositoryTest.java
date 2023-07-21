package com.darak.homepage.repository;

import com.darak.homepage.domain.User;
import com.darak.homepage.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
@SpringBootTest
@Transactional
public class JpaMemberRepositoryTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void save(){
        User user = new User();
//        long a = 1;
//        user.setIdentity(a);
        user.setId("1");
        user.setPassword("1234");
        user.setName("1");

        Long saveIdentity = memberService.join(user);

        User findUser = memberService.findOne(saveIdentity).get();
        Assertions.assertThat(user.getName()).isEqualTo(findUser.getName());
    }
}
