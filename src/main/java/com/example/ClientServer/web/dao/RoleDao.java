package com.example.ClientServer.web.dao;



import com.example.ClientServer.web.model.Role;

import java.util.List;

public interface RoleDao {
    Role getById(Long id);
    Role getRoleByName(String name);
    List<Role> getRoleList();
}
