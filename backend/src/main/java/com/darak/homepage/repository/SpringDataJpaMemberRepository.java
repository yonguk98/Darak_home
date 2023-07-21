package com.darak.homepage.repository;

import com.darak.homepage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<User,Long>, MemberRepository {
    @Override
    Optional<User> findByName(String name);

    @Override
    Optional<User> findByIdentity(Long identity);
}
