package com.application.start.dao;

import com.application.start.entity.Article;
import com.application.start.entity.Society;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional
public class ArticleDAO implements ArticleDAOInterface{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Article createArticle(Article article) {
        Session session=sessionFactory.getCurrentSession();
        session.save(article);
        return article;
    }

    @Override
    public Article updateArticle(int id, Article article) {
        Session session=sessionFactory.getCurrentSession();
        Article article1=session.get(Article.class,id);
        if(article.getName()!=null){
            article1.setName(article.getName());
        }
        if(article.getDescription()!=null){
            article1.setDescription(article.getDescription());
        }
        return article1;
    }

    @Override
    public Article getArticle(int id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Article.class,id);
    }

    @Override
    public String deleteArticle(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(session.get(Article.class,id));
        return "The record deleted successfully";
    }

    @Override
    public Set getAllSocietyArticle(int id) {
        Session session=sessionFactory.getCurrentSession();
        Society society=session.get(Society.class,id);
        System.out.println("Society details"+society.toString());
        Hibernate.initialize(society.getArticleList());
        return society.getArticleList();
    }
}
