package com.darak.homepage.service;

import com.darak.homepage.domain.User;
import com.darak.homepage.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){this.memberRepository = memberRepository;}

    public Long join(User user){
//        validateDuplicateMember(user);
        memberRepository.save(user);
        return user.getIdentity();
    }

    private void validateDuplicateMember(User user){
        memberRepository.findById(user.getId())
                .ifPresent(member1 ->{
                    throw new IllegalStateException("이미 존재하는 아이디 입니다.");
                });
    }

    public List<User> findMembers(){return memberRepository.findAll();}

    public Optional<User> findOne(Long identity){return memberRepository.findByIdentity(identity);}

    //로그인
    public void login(String id, String password){

    }
}
