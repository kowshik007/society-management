package com.application.start.service;

import com.application.start.entity.UserSecurity;

import java.util.Set;

public interface UserSecurityServiceInterface {
    public Set getUserSecurityQuestions(int userId);
    public UserSecurity createUserSecurity(UserSecurity userSecurity);
}
