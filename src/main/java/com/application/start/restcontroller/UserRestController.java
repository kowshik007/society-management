package com.application.start.restcontroller;

import com.application.start.entity.ErrorResponseHandler;
import com.application.start.entity.IdUser;
import com.application.start.entity.UserRole;
import com.application.start.entity.UserSociety;
import com.application.start.exception.DataNotFoundException;
import com.application.start.service.UserRoleServiceInterface;
import com.application.start.service.UserServiceInterface;
import com.application.start.service.UserSocietyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            IdUser idUser=userServiceInterface.getUser(id);
            if(idUser==null){
                throw new DataNotFoundException("DataNotFound:"+id);
            }
            return idUser;
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
