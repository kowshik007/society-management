package com.application.start.dao;

import com.application.start.entity.IdUser;

import java.util.List;

public interface UserDAOInterface {
    public List<IdUser> getUserList();
    public IdUser saveUser(IdUser idUser);
    public IdUser getUser(int id);
    public IdUser updateUser(int id, IdUser idUser);
    public IdUser updateUserStatus(int id, short status, IdUser idUser);
    public IdUser updateUserActive(int id, boolean active, IdUser idUser);
    public void deleteUser(int id);
    public void deleteUser(IdUser idUser);
    public IdUser findByUserName(String email);
}
