package com.application.start.restcontroller;

import com.application.start.entity.Society;
import com.application.start.service.SocietyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocietyController {
    @Autowired
    private SocietyInterface societyInterface;
    @GetMapping("/societies")
    public List<Society> getSocietyList(){
        return societyInterface.getSocietyList();
    }
    @PostMapping("/societies")
    public Society createSociety(@RequestBody Society society){
        return societyInterface.createSociety(society);
    }
    @PutMapping("/society/{id}")
    public Society updateSociety(@PathVariable("id") int id,@RequestBody Society society){
        return societyInterface.updateSociety(id,society);
    }
    @GetMapping("/society/{id}")
    public Society getSociety(@PathVariable("id") int id){
        return societyInterface.getSociety(id);
    }
}
