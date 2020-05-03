package com.application.start.service;

import com.application.start.dao.UserDAOInterface;
import com.application.start.entity.IdUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDAOInterface userDAOInterface;
    @Override
    @Transactional
    public List<IdUser> getUserList() {
        return userDAOInterface.getUserList();
    }

    @Override
    @Transactional
    public IdUser saveUser(IdUser idUser) {
        idUser.setPassword(passwordEncoder.encode(idUser.getPassword()));
        return userDAOInterface.saveUser(idUser);
    }

    @Override
    @Transactional
    public IdUser getUser(int id) {
        return userDAOInterface.getUser(id);
    }

    @Override
    @Transactional
    public IdUser updateUser(int id, IdUser idUser) {
        return userDAOInterface.updateUser(id, idUser);
    }

    @Override
    @Transactional
    public IdUser updateUserStatus(int id, short status, IdUser idUser) {
        return userDAOInterface.updateUserStatus(id,status, idUser);
    }

    @Override
    @Transactional
    public IdUser updateUserActive(int id, boolean active, IdUser idUser) {
        return userDAOInterface.updateUserActive(id,active, idUser);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAOInterface.deleteUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(IdUser idUser) {
        userDAOInterface.deleteUser(idUser);
    }
}
