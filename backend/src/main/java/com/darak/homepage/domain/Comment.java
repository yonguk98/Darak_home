package com.darak.homepage.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @ManyToOne(targetEntity = Board.class)
    @JoinColumn(name = "articleId") // comment table의 입장에서 articleId 한 개와 여러관계를 맺을수 있음
    private long articleId;
    private Date regDate;
    private Date updateDate;
    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name="id")
    private String writer;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
