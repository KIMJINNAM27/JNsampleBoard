package com.Jnsample.Board.dto;

import com.Jnsample.Board.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private final String title;
    private final String content;

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
