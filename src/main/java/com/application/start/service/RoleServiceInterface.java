package com.application.start.service;

import com.application.start.entity.Role;

import java.util.List;

public interface RoleServiceInterface {
    public List<Role> getRoleList();

    public Role createRole(Role role);

    public Role saveRole(int id,Role role);

    public Role getRole(int id);
}
