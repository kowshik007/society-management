package com.application.start.restcontroller;


import com.application.start.service.GatedCommunityVillaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class GatedCommunityVillaController {
    @Autowired
    private GatedCommunityVillaServiceInterface gatedCommunityVillaServiceInterface;
    @GetMapping("/category/villa/{id}")
    public Set villaHomeList(@PathVariable("id") int id){
        return gatedCommunityVillaServiceInterface.villaHomeList(id);
    }
}
