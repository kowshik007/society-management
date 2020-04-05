package com.application.start.dao;

import com.application.start.entity.SocietyArticle;
import com.application.start.entity.UserRole;

public interface SocietyArticleDAOInterface {
    public SocietyArticle mapSocietyArticle(int societyId, int articleId);
}
