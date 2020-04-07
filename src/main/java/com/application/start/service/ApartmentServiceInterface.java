package com.application.start.service;

import com.application.start.entity.Apartment;

import java.util.Set;

public interface ApartmentServiceInterface {
    public Apartment createApartment(Apartment apartment);
    public Apartment updateApartment(int id, Apartment apartment);
    public Apartment getApartment(int id);
    public String deleteApartment(int id);
    public Set getApartmentSet();
}
