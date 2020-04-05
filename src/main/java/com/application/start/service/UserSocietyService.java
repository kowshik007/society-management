package com.application.start.service;

import com.application.start.dao.UserSocietyDAOInterface;
import com.application.start.entity.UserSociety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserSocietyService implements UserSocietyInterface {
    @Autowired
    private UserSocietyDAOInterface userSocietyDAOInterface;
    @Override
    @Transactional
    public UserSociety mapUserSociety(int userid, int societyid) {
        return userSocietyDAOInterface.mapUserSociety(userid,societyid);
    }
}
