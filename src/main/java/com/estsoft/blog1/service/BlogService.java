package com.estsoft.blog1.service;

import com.estsoft.blog1.domain.Article;
import com.estsoft.blog1.dto.AddArticleRequest;
import com.estsoft.blog1.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
    public List<Article> findAll() {
        return blogRepository.findAll();
    }
}