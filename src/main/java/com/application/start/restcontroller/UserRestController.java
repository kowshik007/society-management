package com.application.start.restcontroller;

import com.application.start.entity.IdUser;
import com.application.start.entity.UserRole;
import com.application.start.entity.UserSociety;
import com.application.start.service.UserRoleServiceInterface;
import com.application.start.service.UserServiceInterface;
import com.application.start.service.UserSocietyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserServiceInterface userServiceInterface;
    @Autowired
    private UserRoleServiceInterface userRoleServiceInterface;
    @Autowired
    private UserSocietyInterface userSocietyInterface;
    @GetMapping(path = "/users")
    public List<IdUser> getUserList(){
        return userServiceInterface.getUserList();
    }
    @GetMapping(path = "/users/{id}")
    public IdUser getUser(@PathVariable("id") int id){
        return userServiceInterface.getUser(id);
    }
    @PostMapping(path = "/users")
    public IdUser saveUser(@RequestBody IdUser idUser){
        return  userServiceInterface.saveUser(idUser);
    }
    @PutMapping(path = "/users/{id}")
    public IdUser updateUser(@PathVariable int id, @RequestBody IdUser idUser){
        System.out.println("User details in controller:"+ idUser);
        return userServiceInterface.updateUser(id, idUser);
    }
    @GetMapping(path = "/user_role/{userid}/{roleid}")
    public UserRole mapUserRole(@PathVariable("userid") int userid, @PathVariable("roleid") int roleid){
        return userRoleServiceInterface.mapUserRole(userid,roleid);
    }

    @GetMapping(path = "/user_society/{userid}/{societyid}")
    public UserSociety mapUserSociety(@PathVariable("userid") int userid, @PathVariable("societyid") int societyid){
        return userSocietyInterface.mapUserSociety(userid,societyid);
    }
}
