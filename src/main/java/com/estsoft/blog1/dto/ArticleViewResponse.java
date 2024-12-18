package com.estsoft.blog1.dto;

import com.estsoft.blog1.domain.Article;

public class ArticleViewResponse {
    private Long id;
    private String title;
    private String content;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}