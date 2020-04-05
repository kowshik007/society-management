package com.application.start.service;

import com.application.start.dao.UserRoleDAOInterface;
import com.application.start.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleService implements UserRoleServiceInterface {
    @Autowired
    private UserRoleDAOInterface userRoleDAOInterface;
    @Override
    @Transactional
    public UserRole mapUserRole(int userid, int roleid) {
        return userRoleDAOInterface.mapUserRole(userid,roleid);
    }
}
