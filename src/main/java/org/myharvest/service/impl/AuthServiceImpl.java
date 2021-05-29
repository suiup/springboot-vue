package org.myharvest.service.impl;

import org.myharvest.dao.AuthDao;
import org.myharvest.pojo.Auth;
import org.myharvest.pojo.User;
import org.myharvest.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthDao authDao;

    @Override
    public void add(Auth auth) {
        authDao.save(auth);
    }

    @Override
    public void deleteByAuthId(Integer authId) {
        authDao.deleteByAuthId(authId);
    }

    @Override
    public void edit(Auth auth) {
        authDao.save(auth);
    }

    @Override
    public List<Auth> findAll() {
        return authDao.findAll();
    }

    @Override
    public Auth findAuthByAuthId(Integer authId) {
        Auth auth = authDao.findAuthByAuthId(authId);
        if(auth == null){
            return null;
        }
        System.out.println(auth);
        String authName = auth.getAuthName();
        System.out.println(authName);
        return auth;
    }

}
