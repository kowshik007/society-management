package com.application.start.dao;

import com.application.start.entity.Apartment;
import com.application.start.entity.Category;
import com.application.start.entity.Villa;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional
public class CategoryDAO implements CategoryDAOInterface {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Set getList(String name) {
        if(name=="apartment") {
            Session session = sessionFactory.getCurrentSession();
            Category category = session.createQuery("from Category where name=:name", Category.class)
                    .setParameter("name", name)
                    .getSingleResult();
            Hibernate.initialize(category.getApartmentList());
            Set<Apartment> apartmentSet = category.getApartmentList();
            return apartmentSet;
        }else if(name=="villa"){
            Session session = sessionFactory.getCurrentSession();
            Category category = session.createQuery("from Category where name=:name", Category.class)
                    .setParameter("name", name)
                    .getSingleResult();
            Hibernate.initialize(category.getGatedCommunityList());
            Set<Villa> villaSet=category.getGatedCommunityList();
            return villaSet;
        }else{
            return null;
        }
    }

}
