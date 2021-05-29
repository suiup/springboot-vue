package org.myharvest.dao;

import org.myharvest.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends JpaRepository<Role,Integer> {
    List<Role> findAll();

    void deleteByRoleId(Integer roleId);
}
