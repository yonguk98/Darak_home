package com.darak.homepage.domain;

import jakarta.persistence.*;

@Entity
public class File {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fileId;

    @ManyToOne(targetEntity = Board.class)
    @JoinColumn(name = "articleId")
    private long articleId;

    private String filePath;

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
