package com.darak.homepage.service;

import com.darak.homepage.domain.Users;
import com.darak.homepage.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){this.memberRepository = memberRepository;}

    public Long join(Users users){
//        validateDuplicateMember(users);
        memberRepository.save(users);
        return users.getIdentity();
    }

    private void validateDuplicateMember(Users users){
        memberRepository.findById(users.getId())
                .ifPresent(member1 ->{
                    throw new IllegalStateException("이미 존재하는 아이디 입니다.");
                });
    }

    public List<Users> findMembers(){return memberRepository.findAll();}

    public Optional<Users> findOne(Long identity){return memberRepository.findByIdentity(identity);}

    //로그인
//    public Optional<Users> login(String id, String password){
//        //아이디 비밀번호로 일치하는 유저 있는지 확인
//        Optional<Users> resultById = memberRepository.findById(id);
//        Optional<Users> resultByPassword = memberRepository.findByPassword(password);
//
//        if (resultByPassword == resultById){
//            return resultById;
//        }
//        return none;
//    }
    public boolean login(String id, String password){
        Users userById = memberRepository.findById(id).get();
        if (userById != null){
            if (userById.getPassword().equals(password)){
                return true;
            }
            else{return false;}
        }

        return false;
    }

}
