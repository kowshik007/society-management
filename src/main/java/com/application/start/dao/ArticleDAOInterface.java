package com.application.start.dao;

import com.application.start.entity.Article;

import java.util.Set;

public interface ArticleDAOInterface {
    public Article createArticle(Article article);
    public Article updateArticle(int id,Article article);
    public Article getArticle(int id);
    public String deleteArticle(int id);
    public Set getAllSocietyArticle(int id);
}
