package com.darak.homepage.repository;

import com.darak.homepage.domain.User;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    User save(User user);

    Optional<User> findByIdentity(Long identity);

    Optional<User> findById(String id);

    Optional<User> findByPassword(String password);

    Optional<User> findByName(String name);

    List<User> findAll();
}
