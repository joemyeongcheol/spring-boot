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
    // 삭제 로직 추가
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    // blog 게시글 단건 상세조회
    public Article findBy(Long id) {
        return blogRepository.findById(id).orElse(new Article());
    }
}