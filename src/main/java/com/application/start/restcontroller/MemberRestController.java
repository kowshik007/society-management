package com.application.start.restcontroller;

import com.application.start.service.MemberServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class MemberRestController {
    @Autowired
    private MemberServiceInterface memberServiceInterface;
    @GetMapping("/category/{category}/home/{homeid}/members")
    public Set getVillaMemberDetails(@PathVariable("category") String category,@PathVariable("homeid") int homeid){
        return memberServiceInterface.getMemberDetails(category,homeid);
    }

    @GetMapping("/category/{category}/home/{homeid}/deliveries")
    public Set getDeliveryDetails(@PathVariable("category") String category,@PathVariable("homeid") int homeid){
        return memberServiceInterface.getDeliveryDetails(category,homeid);
    }
}
