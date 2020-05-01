package com.application.start.dao;

import com.application.start.entity.Society;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SocietyDAO implements SocietyDAOInterface {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Society> getSocietyList() {
        Session session=sessionFactory.getCurrentSession();
        List<Society> societyList=session.createQuery("from Society",Society.class).getResultList();
        for(Society society: societyList){
            Hibernate.initialize(society.getArticleList());
        }
        return societyList;
    }

    @Override
    public Society createSociety(Society society) {
        Session session=sessionFactory.getCurrentSession();
        session.save(society);
        return society;
    }

    @Override
    public Society updateSociety(int id, Society society) {
        Session session=sessionFactory.getCurrentSession();
        Society tempSociety=session.get(Society.class,id);
        if(society.getName()!=null){
            tempSociety.setName(society.getName());
        }else if(society.getPincode()!=0){
            tempSociety.setPincode(society.getPincode());
        }else if(society.getOfficeName()!=null){
            tempSociety.setOfficeName(society.getOfficeName());
        }
        return tempSociety;
    }

    @Override
    public Society getSociety(int id) {
        Session session=sessionFactory.getCurrentSession();
        Society society=session.get(Society.class,id);
        Hibernate.initialize(society.getArticleList());
        return society;
    }
}
