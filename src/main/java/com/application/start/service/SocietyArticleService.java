package com.application.start.service;

import com.application.start.dao.SocietyArticleDAOInterface;
import com.application.start.entity.SocietyArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SocietyArticleService implements SocietyArticleInterface{
    @Autowired
    private SocietyArticleDAOInterface societyArticleDAOInterface;

    @Override
    @Transactional
    public SocietyArticle mapSocietyArticle(int societyId, int articleId) {
        return societyArticleDAOInterface.mapSocietyArticle(societyId,articleId);
    }
}
