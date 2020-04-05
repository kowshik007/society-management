package com.application.start.dao;

import com.application.start.entity.Home;
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
public class MemberDAO implements MemberDAOInterface{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Set getMemberDetails(String category,int homeid) {
        if(category.contains("villa")){
            Session session=sessionFactory.getCurrentSession();
            Villa villa=session.createQuery("from Villa where id=:homeid", Villa.class)
                    .setParameter("homeid",homeid)
                    .getSingleResult();
            Hibernate.initialize(villa.getVillaMemberList());
            Set villaMemberList=villa.getVillaMemberList();
            return villaMemberList;
        }
        else if(category.contains("apartment")){
            Session session=sessionFactory.getCurrentSession();
            Home home=session.createQuery("from Home where id=:homeid", Home.class)
                    .setParameter("homeid",homeid)
                    .getSingleResult();
            Set MemberList=home.getMembers();
            return MemberList;
        }
        else {
            System.out.println("Category is: "+category);
            return null;
        }
    }

    @Override
    public Set getDeliveryDetails(String category, int homeid) {
        if(category.contains("villa")){
            Session session=sessionFactory.getCurrentSession();
            Villa villa=session.createQuery("from Villa where id=:homeid", Villa.class)
                    .setParameter("homeid",homeid)
                    .getSingleResult();
            Hibernate.initialize(villa.getVillaDeliveryList());
            return villa.getVillaDeliveryList();
        }else if(category.contains("apartment")) {
            Session session=sessionFactory.getCurrentSession();
            Home home=session.createQuery("from Home where id=:homeid", Home.class)
                    .setParameter("homeid",homeid)
                    .getSingleResult();
            Hibernate.initialize(home.getHomeDelivery());
            return home.getHomeDelivery();
        }else{
            return null;
        }
    }
}
