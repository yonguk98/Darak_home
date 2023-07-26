package com.darak.homepage.repository;

import com.darak.homepage.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Users,Long>, MemberRepository {
    @Override
    Optional<Users> findByName(String name);

    @Override
    Optional<Users> findByIdentity(Long identity);
}
