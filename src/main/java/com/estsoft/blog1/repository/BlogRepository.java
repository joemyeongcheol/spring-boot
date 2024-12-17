package com.estsoft.blog1.repository;

import com.estsoft.blog1.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}