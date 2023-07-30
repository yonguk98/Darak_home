package com.darak.homepage.repository.MemberRepository;

import com.darak.homepage.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Users,Long> {
    Optional<Users> findById(String id);
    Optional<Users> findByName(String name);

    Optional<Users> findByIdentity(Long identity);
}
