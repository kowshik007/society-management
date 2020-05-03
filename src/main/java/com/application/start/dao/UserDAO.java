package com.application.start.dao;

import com.application.start.entity.IdUser;
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
    public List<IdUser> getUserList() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<IdUser> theQuery =
                currentSession.createQuery("from IdUser", IdUser.class);
//        for(User user:theQuery.getResultList()){
//            Hibernate.initialize(user.getUserSecurityList());
//        }
        // execute query and get result list
        return theQuery.getResultList();
    }

    @Override
    public IdUser saveUser(IdUser idUser) {
        Session session=sessionFactory.getCurrentSession();
        session.save(idUser);
        return idUser;
    }

    @Override
    public IdUser getUser(int id) {
        Session session=sessionFactory.getCurrentSession();
        IdUser idUser =session.get(IdUser.class,id);
        return idUser;
    }

    @Override
    public IdUser updateUser(int id, IdUser idUser) {
        Session session=sessionFactory.getCurrentSession();
        IdUser tempIdUser =session.get(IdUser.class,id);
        if(idUser.getEmail()!=null){
            tempIdUser.setEmail(idUser.getEmail());
        }
        if(idUser.getPassword()!=null){
            tempIdUser.setPassword(idUser.getPassword());
        }
        if(idUser.getPhone()!=null){
            tempIdUser.setPhone(idUser.getPhone());
        }
        session.save(tempIdUser);
        return tempIdUser;
    }

    @Override
    public IdUser updateUserStatus(int id, short status, IdUser idUser) {
        Session session=sessionFactory.getCurrentSession();
        IdUser tempIdUser =session.get(IdUser.class,id);
        tempIdUser.setStatus(status);
        return tempIdUser;
    }

    @Override
    public IdUser updateUserActive(int id, boolean active, IdUser idUser) {
        Session session=sessionFactory.getCurrentSession();
        IdUser tempIdUser =session.get(IdUser.class,id);
        tempIdUser.setActive(active);
        return tempIdUser;
    }

    @Override
    public void deleteUser(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(session.get(IdUser.class,id));
    }

    @Override
    public void deleteUser(IdUser idUser) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(idUser);
    }

    @Override
    public IdUser findByUserName(String email) {
        Session session=sessionFactory.getCurrentSession();
        IdUser idUser=session.createQuery("from IdUser where email=:email",IdUser.class)
                .setParameter("email",email)
                .getSingleResult();
        return idUser;
    }
}
