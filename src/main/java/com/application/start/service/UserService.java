package com.application.start.service;

import com.application.start.dao.UserDAOInterface;
import com.application.start.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private UserDAOInterface userDAOInterface;
    @Override
    @Transactional
    public List<User> getUserList() {
        return userDAOInterface.getUserList();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userDAOInterface.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDAOInterface.getUser(id);
    }

    @Override
    @Transactional
    public User updateUser(int id,User user) {
        return userDAOInterface.updateUser(id,user);
    }

    @Override
    @Transactional
    public User updateUserStatus(int id, short status, User user) {
        return userDAOInterface.updateUserStatus(id,status,user);
    }

    @Override
    @Transactional
    public User updateUserActive(int id, boolean active, User user) {
        return userDAOInterface.updateUserActive(id,active,user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAOInterface.deleteUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDAOInterface.deleteUser(user);
    }
}
