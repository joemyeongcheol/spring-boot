package com.estsoft.blog1.dto;

import com.estsoft.blog1.domain.Article;

public class ArticleResponse {
    private String title;
    private String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }

    public ArticleResponse(Long id, String title, String content) {
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}