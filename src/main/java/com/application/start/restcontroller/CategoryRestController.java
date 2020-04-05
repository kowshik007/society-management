package com.application.start.restcontroller;

import com.application.start.entity.Apartment;
import com.application.start.entity.Villa;
import com.application.start.service.CategoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class CategoryRestController {
    @Autowired
    private CategoryInterface categoryInterface;
    @GetMapping("/category/apartment")
    public Set<Apartment> getApartmentList(){
        String name="apartment";
        return categoryInterface.getList(name);
    }

    @GetMapping("/category/villa")
    public Set<Villa> getVillaList(){
        String name="villa";
        return categoryInterface.getList(name);
    }
}
