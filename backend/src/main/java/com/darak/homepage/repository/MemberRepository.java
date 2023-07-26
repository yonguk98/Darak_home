package com.darak.homepage.repository;

import com.darak.homepage.domain.Users;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Users save(Users users);

    Optional<Users> findByIdentity(Long identity);

    Optional<Users> findById(String id);

    Optional<Users> findByPassword(String password);

    Optional<Users> findByName(String name);

    List<Users> findAll();
}
