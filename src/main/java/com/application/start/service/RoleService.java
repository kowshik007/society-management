package com.application.start.service;

import com.application.start.dao.RoleDAOInterface;
import com.application.start.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService implements RoleServiceInterface{
    @Autowired
    private RoleDAOInterface roleDAOInterface;

    @Override
    @Transactional
    public List<Role> getRoleList() {
        return roleDAOInterface.getRoleList();
    }

    @Override
    @Transactional
    public Role createRole(Role role) {
        return roleDAOInterface.createRole(role);
    }

    @Override
    @Transactional
    public Role saveRole(int id, Role role) {
        return roleDAOInterface.saveRole(id,role);
    }

    @Override
    @Transactional
    public Role getRole(int id) {
        return roleDAOInterface.getRole(id);
    }
}
