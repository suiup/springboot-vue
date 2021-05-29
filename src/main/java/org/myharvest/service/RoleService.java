package org.myharvest.service;

import org.myharvest.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void deleteById(Integer id);

    void add(Role role);
}
