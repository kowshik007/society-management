package com.application.start.dao;


import com.application.start.entity.GatedCommunityVilla;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional
public class GatedCommunityVillaDAO implements GatedCommunityVillaInterface{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Set villaHomeList(int id) {
        Session session=sessionFactory.getCurrentSession();
        GatedCommunityVilla gatedCommunityVilla =session.createQuery("from GatedCommunityVilla where id=:id",GatedCommunityVilla.class)
                .setParameter("id",id)
                .getSingleResult();
        Hibernate.initialize(gatedCommunityVilla.getVillaList());
        Set gatedCommunityList=gatedCommunityVilla.getVillaList();
        return gatedCommunityList;
    }
}
