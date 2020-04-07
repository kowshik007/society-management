package com.application.start.dao;

import com.application.start.entity.UserSecurity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional
public class UserSecurityDAO implements UserSecurityDAOInterface{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Set getUserSecurityQuestions(int userId) {
        Session session=sessionFactory.getCurrentSession();
        Set setUserSecurity=new HashSet<UserSecurity>();
        session.createQuery("from UserSecurity where userid=:userId",UserSecurity.class)
                .setParameter("userId",userId)
                .list()
                .iterator().forEachRemaining(userSecurity -> {
                    setUserSecurity.add(userSecurity);
                });
        return setUserSecurity;
    }

    @Override
    public UserSecurity createUserSecurity(UserSecurity userSecurity) {
        Session session=sessionFactory.getCurrentSession();
        session.save(userSecurity);
        return userSecurity;
    }
}
