package com.application.start.restcontroller;

import com.application.start.service.ApartmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ApartmentRestController {
    @Autowired
    private ApartmentServiceInterface apartmentServiceInterface;

    @GetMapping("/apartments")
    public Set getApartmentSet(){
        return apartmentServiceInterface.getApartmentSet();
    }
}
