package com.darak.homepage.repository.BoardRepository;

import com.darak.homepage.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BoardRepository extends JpaRepository<Board,Long> {
    @Override
    Board save(Board board);

    Board findByArticleId(long articleId);

    Board findByWriter(String writer);

}
