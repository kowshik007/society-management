package com.application.start.dao;

import com.application.start.entity.UserSociety;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserSocietyDAO implements UserSocietyDAOInterface {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public UserSociety mapUserSociety(int userid, int societyid) {
        UserSociety userSociety=new UserSociety(userid,societyid);
        Session session=sessionFactory.getCurrentSession();
        session.save(userSociety);
        return userSociety;
    }
}
