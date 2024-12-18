package com.estsoft.blog1.controller;

import com.estsoft.blog1.domain.Article;
import com.estsoft.blog1.dto.ArticleViewResponse;
import com.estsoft.blog1.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BlogPageController {
    private BlogService blogService;

    public BlogPageController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleViewResponse> articles = blogService.findAll().stream()
                .map(ArticleViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);   // model에 블로그 글 리스트 저장

        return "articleList";   // articleList.html라는 뷰 조회
    }

    @GetMapping("/articles/{id}")
    public String showArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findBy(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }
}