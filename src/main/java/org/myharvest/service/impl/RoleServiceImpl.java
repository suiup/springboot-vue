package org.myharvest.service.impl;

import org.myharvest.dao.RoleDao;
import org.myharvest.pojo.Role;
import org.myharvest.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        roleDao.deleteByRoleId(id);
    }

    @Override
    public void add(Role role) {
        roleDao.save(role);
    }

}
