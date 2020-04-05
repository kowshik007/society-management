package com.application.start.dao;

import com.application.start.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class UserDAO implements UserDAOInterface {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<User> getUserList() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<User> theQuery =
                currentSession.createQuery("from User", User.class);
        for(User user:theQuery.getResultList()){
            Hibernate.initialize(user.getUserSecurityList());
        }
        // execute query and get result list
        return theQuery.getResultList();
    }

    @Override
    public User saveUser(User user) {
        Session session=sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Override
    public User getUser(int id) {
        Session session=sessionFactory.getCurrentSession();
        User user=session.get(User.class,id);
        Hibernate.initialize(user.getUserSecurityList());
        return user;
    }

    @Override
    public User updateUser(int id,User user) {
        Session session=sessionFactory.getCurrentSession();
        User tempUser=session.get(User.class,id);
        if(user.getEmail()!=null){
            tempUser.setEmail(user.getEmail());
        }
        if(user.getPassword()!=null){
            tempUser.setPassword(user.getPassword());
        }
        if(user.getPhone()!=null){
            tempUser.setPhone(user.getPhone());
        }
        session.save(tempUser);
        return tempUser;
    }

    @Override
    public User updateUserStatus(int id,short status, User user) {
        Session session=sessionFactory.getCurrentSession();
        User tempUser=session.get(User.class,id);
        tempUser.setStatus(status);
        return tempUser;
    }

    @Override
    public User updateUserActive(int id, boolean active, User user) {
        Session session=sessionFactory.getCurrentSession();
        User tempUser=session.get(User.class,id);
        tempUser.setActive(active);
        return tempUser;
    }

    @Override
    public void deleteUser(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(session.get(User.class,id));
    }

    @Override
    public void deleteUser(User user) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(user);
    }
}
