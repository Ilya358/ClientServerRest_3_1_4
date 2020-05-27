package com.example.ClientServer.web.service;

import com.example.ClientServer.web.model.Role;

import java.util.List;

public interface RoleService {

    Role getById(Long id);

    Role getRoleByName(String name);

    List<Role> roleList();
}
