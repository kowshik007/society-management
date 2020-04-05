package com.application.start.dao;

import com.application.start.entity.Role;

import java.util.List;

public interface RoleDAOInterface {

    public List<Role> getRoleList();

    public Role createRole(Role role);

    public Role saveRole(int id,Role role);

    public Role getRole(int id);
}
