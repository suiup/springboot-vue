package org.myharvest.service;

import org.myharvest.pojo.Auth;
import org.myharvest.pojo.User;

import java.util.List;

public interface AuthService {

    void add(Auth auth);

    void deleteByAuthId(Integer authId);

    void edit(Auth auth);

    List<Auth> findAll();

    Auth findAuthByAuthId(Integer authId);

}
