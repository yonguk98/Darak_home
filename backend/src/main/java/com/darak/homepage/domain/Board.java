package com.darak.homepage.domain;

import ch.qos.logback.core.model.processor.AllowAllModelFilter;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long articleId;
    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "id")
    private String writer;
    private String title;
    private Date regDate;
    private Date updateDate;
    private String boardCategory;
    private String content;
    private long like;


    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regdate) {
        this.regDate = regdate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updatedate) {
        this.updateDate = updatedate;
    }

    public String getBoardCategory() {
        return boardCategory;
    }

    public void setBoardCategory(String boardCategory) {
        this.boardCategory = boardCategory;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
