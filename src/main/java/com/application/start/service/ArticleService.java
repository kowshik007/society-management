package com.application.start.service;

import com.application.start.dao.ArticleDAOInterface;
import com.application.start.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ArticleService implements ArticleServiceInterface {
    @Autowired
    private ArticleDAOInterface articleDAOInterface;
    @Override
    @Transactional
    public Article createArticle(Article article) {
        return articleDAOInterface.createArticle(article);
    }

    @Override
    @Transactional
    public Article updateArticle(int id, Article article) {
        return articleDAOInterface.updateArticle(id,article);
    }

    @Override
    @Transactional
    public Article getArticle(int id) {
        return articleDAOInterface.getArticle(id);
    }

    @Override
    @Transactional
    public String deleteArticle(int id) {
        return articleDAOInterface.deleteArticle(id);
    }

    @Override
    @Transactional
    public Set getAllSocietyArticle(int id) {
        return articleDAOInterface.getAllSocietyArticle(id);
    }
}
