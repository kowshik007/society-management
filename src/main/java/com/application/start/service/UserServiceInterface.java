package com.application.start.service;

import com.application.start.entity.User;

import java.util.List;

public interface UserServiceInterface {
    public List<User> getUserList();
    public User saveUser(User user);
    public User getUser(int id);
    public User updateUser(int id,User user);
    public User updateUserStatus(int id,short status,User user);
    public User updateUserActive(int id,boolean active,User user);
    public void deleteUser(int id);
    public void deleteUser(User user);
}
