package com.application.start.service;

import com.application.start.dao.UserSecurityDAOInterface;
import com.application.start.entity.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserSecurityService implements UserSecurityServiceInterface {

    @Autowired
    private UserSecurityDAOInterface userSecurityDAOInterface;
    @Override
    @Transactional
    public Set getUserSecurityQuestions(int userId) {
        return userSecurityDAOInterface.getUserSecurityQuestions(userId);
    }

    @Override
    @Transactional
    public UserSecurity createUserSecurity(UserSecurity userSecurity) {
        return userSecurityDAOInterface.createUserSecurity(userSecurity);
    }
}
