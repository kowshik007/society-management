package com.application.start.dao;

import com.application.start.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RoleDAO implements RoleDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Role> getRoleList() {
        Session session=sessionFactory.getCurrentSession();
        List<Role> roleList=session.createQuery("from Role").getResultList();
        return roleList;
    }

    @Override
    public Role createRole(Role role) {
        Session session=sessionFactory.getCurrentSession();
        session.save(role);
        return role;
    }

    @Override
    public Role saveRole(int id, Role role) {
        Session session=sessionFactory.getCurrentSession();
        Role getRole=session.get(Role.class,id);
        if(role.getName()!=null){
            getRole.setName(role.getName());
        }
        return getRole;
    }

    @Override
    public Role getRole(int id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Role.class,id);
    }
}
