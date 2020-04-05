package com.application.start.restcontroller;

import com.application.start.entity.Role;
import com.application.start.service.RoleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleRestController {
    @Autowired
    private RoleServiceInterface roleServiceInterface;

    @GetMapping(path = "/roles")
    public List<Role> getRoleList(){
        return roleServiceInterface.getRoleList();
    }

    @GetMapping(path = "/roles/{id}")
    public Role getRole(@PathVariable int id){
        return roleServiceInterface.getRole(id);
    }

    @PostMapping(path = "/roles")
    public Role createRole(@RequestBody Role role){
        return roleServiceInterface.createRole(role);
    }

    @PutMapping(path = "/roles/{id}")
    public Role saveRole(@PathVariable int id,@RequestBody Role role){
        return roleServiceInterface.saveRole(id,role);
    }
}
