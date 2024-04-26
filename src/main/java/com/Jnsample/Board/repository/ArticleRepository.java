package com.Jnsample.Board.repository;

import com.Jnsample.Board.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
