package com.application.start.service;

import com.application.start.dao.ApartmentDAOInterface;
import com.application.start.entity.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ApartmentService implements ApartmentServiceInterface {
    @Autowired
    private ApartmentDAOInterface apartmentDAOInterface;
    @Override
    @Transactional
    public Apartment createApartment(Apartment apartment) {
        return apartmentDAOInterface.createApartment(apartment);
    }

    @Override
    @Transactional
    public Apartment updateApartment(int id, Apartment apartment) {
        return apartmentDAOInterface.updateApartment(id,apartment);
    }

    @Override
    @Transactional
    public Apartment getApartment(int id) {
        return apartmentDAOInterface.getApartment(id);
    }

    @Override
    @Transactional
    public String deleteApartment(int id) {
        return apartmentDAOInterface.deleteApartment(id);
    }

    @Override
    @Transactional
    public Set getApartmentSet() {
        return apartmentDAOInterface.getApartmentSet();
    }
}
