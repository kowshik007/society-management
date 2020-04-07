package com.application.start.dao;

import com.application.start.entity.Apartment;
import com.application.start.entity.Floor;
import com.application.start.entity.Home;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class ApartmentDAO implements ApartmentDAOInterface{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Apartment createApartment(Apartment apartment) {
        Session session=sessionFactory.getCurrentSession();
        session.save(apartment);
        return apartment;
    }

    @Override
    public Apartment updateApartment(int id, Apartment apartment) {
        Session session=sessionFactory.getCurrentSession();
        Apartment tempApartment=session.get(Apartment.class,id);
        if(apartment.getName()!=null){
            tempApartment.setName(apartment.getName());
        }
        return tempApartment;
    }

    @Override
    public Apartment getApartment(int id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Apartment.class,id);
    }

    @Override
    public String deleteApartment(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(session.get(Apartment.class,id));
        return "Succesfully deleted apartment";
    }

    @Override
    public Set getApartmentSet() {
        Session session=sessionFactory.getCurrentSession();
        List<Apartment> apartmentList= session.createQuery("from Apartment",Apartment.class).list();
        for(Apartment apartment:apartmentList){
            Hibernate.initialize(apartment.getFloorList());
            Set<Floor> floorSet=apartment.getFloorList();
            floorSet.iterator().forEachRemaining(floor -> {
                Hibernate.initialize(floor.getFlatList());
                Set<Home> homeSet=new HashSet<>(floor.getFlatList());
                homeSet.iterator().forEachRemaining(home -> {
                    Hibernate.initialize(home.getHomeDelivery());
                });
            });
        }
        Set<Apartment> apartmentHashSet=new HashSet<>(apartmentList);
        return apartmentHashSet;
    }
}
