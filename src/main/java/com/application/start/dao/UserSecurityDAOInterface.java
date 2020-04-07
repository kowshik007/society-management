package com.application.start.dao;

import com.application.start.entity.UserSecurity;

import java.util.Set;

public interface UserSecurityDAOInterface {
    public Set getUserSecurityQuestions(int userId);
    public UserSecurity createUserSecurity(UserSecurity userSecurity);
}
