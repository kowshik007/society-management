package com.application.start.restcontroller;

import com.application.start.entity.Article;
import com.application.start.service.ArticleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ArticleRestController {
    @Autowired
    private ArticleServiceInterface articleServiceInterface;
    @PostMapping("/articles")
    public Article createArticle(@RequestBody Article article){
        return articleServiceInterface.createArticle(article);
    }
    @PutMapping("/article/{id}")
    public Article updateArticle(@PathVariable("id") int id,@RequestBody Article article){
        return articleServiceInterface.updateArticle(id,article);
    }
    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable("id") int id){
        return articleServiceInterface.getArticle(id);
    }
    @DeleteMapping("/articles/{id}")
    public String deleteArticle(@PathVariable("id") int id){
        return articleServiceInterface.deleteArticle(id);
    }
    @GetMapping("/society/{societyId}/articles")
    public Set getAllSocietyArticle(@PathVariable("societyId") int societyId){
        return articleServiceInterface.getAllSocietyArticle(societyId);
    }
}
