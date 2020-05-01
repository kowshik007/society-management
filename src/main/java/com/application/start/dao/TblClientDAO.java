package com.application.start.dao;

import com.application.start.entity.TblClient;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional
public class TblClientDAO implements TblClientDAOInterface {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Set<TblClient> getClientList() {
        Set<TblClient> tblClientSet=new HashSet<TblClient>();
        Session session=sessionFactory.getCurrentSession();
        session.createQuery("from TblClient",TblClient.class).getResultStream().iterator().forEachRemaining(tblClient -> {
            tblClientSet.add(tblClient);
        });
        for (TblClient tblClient:tblClientSet){
            Hibernate.initialize(tblClient.getTblAuthoritySet());
            Hibernate.initialize(tblClient.getTblScopeSet());
        }
        return tblClientSet;
    }

    @Override
    public TblClient findByClientUserId(String clientUserId) {
        Session session=sessionFactory.getCurrentSession();
        TblClient tblClient=session.createQuery("from TblClient where clientUserId=:clientUserId",TblClient.class).setParameter("clientUserId",clientUserId).getSingleResult();
        Hibernate.initialize(tblClient.getTblAuthoritySet());
        Hibernate.initialize(tblClient.getTblScopeSet());
        return tblClient;
    }
}
