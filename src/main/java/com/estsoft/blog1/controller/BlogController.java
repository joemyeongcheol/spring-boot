package com.estsoft.blog1.controller;

import com.estsoft.blog1.domain.Article;
import com.estsoft.blog1.dto.AddArticleRequest;
import com.estsoft.blog1.dto.ArticleResponse;
import com.estsoft.blog1.dto.UpdateArticleRequest;
import com.estsoft.blog1.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController        // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogController {
    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    // HTTP요청이 'POST /api/articles' 경로일 때 해당 메소드로 매핑
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) { // RequestBody로 요청 본문 값 매핑
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> list = blogService.findAll()
                .stream().map(ArticleResponse::new)
                .toList();
        return ResponseEntity.status(HttpStatus.OK)
                .body(list);
    }

    // 단건 조회 API (Request mapping) 만들기
    @GetMapping("api/articles/{id}")
    public ResponseEntity<ArticleResponse> findById(@PathVariable Long id) {
        Article article = blogService.findBy(id);
        return ResponseEntity.ok(article.convert());
    }

    // DELETE /article/{id}
    @DeleteMapping("api/articles/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = blogService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(updatedArticle);
    }
}