package com.darak.homepage.repository.CommentRepository;

import com.darak.homepage.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment save(Comment comment);

    Optional<Comment> findByArticleId(long articleId);
    Optional<Comment> findByWriter(String writer);
    Optional<Comment> findByIdx(long idx);



}
