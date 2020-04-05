package com.application.start.dao;

import com.application.start.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class UserRoleDAO implements UserRoleDAOInterface {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public UserRole mapUserRole(int userid, int roleid) {
        UserRole userRole=new UserRole(userid,roleid);
        Session session=sessionFactory.getCurrentSession();
        session.save(userRole);
        return userRole;
    }
}
