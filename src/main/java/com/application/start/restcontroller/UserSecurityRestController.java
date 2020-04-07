package com.application.start.restcontroller;

import com.application.start.entity.UserSecurity;
import com.application.start.service.UserSecurityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserSecurityRestController {
    @Autowired
    private UserSecurityServiceInterface userSecurityServiceInterface;
    @GetMapping("/user/{userId}/usersecurity")
    public Set getUserSecurityQuestions(@PathVariable("userId") int userId){
        return userSecurityServiceInterface.getUserSecurityQuestions(userId);
    }
    @PostMapping("/user/{userId}/usersecurity")
    public UserSecurity createUserSecurity(@RequestBody UserSecurity userSecurity){
        return userSecurityServiceInterface.createUserSecurity(userSecurity);
    }
}
