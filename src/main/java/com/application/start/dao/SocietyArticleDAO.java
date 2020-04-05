package com.application.start.dao;

import com.application.start.entity.SocietyArticle;
import com.application.start.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SocietyArticleDAO implements SocietyArticleDAOInterface {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public SocietyArticle mapSocietyArticle(int societyId, int articleId) {
        SocietyArticle societyArticle=new SocietyArticle(societyId,articleId);
        Session session=sessionFactory.getCurrentSession();
        session.save(societyArticle);
        return societyArticle;
    }
}
