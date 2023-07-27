package com.darak.homepage.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String content;

    private int like;
}
