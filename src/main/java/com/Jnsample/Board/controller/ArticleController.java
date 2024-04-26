package com.Jnsample.Board.controller;

import com.Jnsample.Board.dto.ArticleForm;
import com.Jnsample.Board.entity.Article;
import com.Jnsample.Board.repository.ArticleRepository;
import jakarta.persistence.Id;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());

        Article article = form.toEntity();
        log.info(article.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "/articles/new";

    }

    @GetMapping("articles/view")
    public String articlesView(Model model, Long id) {
        model.addAttribute("article", articleRepository.findById(id).orElse(null));
        return "articles/view";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id =" + id);

        Optional<Article> articleEntity = articleRepository.findById(id);

        model.addAttribute("article", articleEntity);
        return "/articles/show";
    }
}
