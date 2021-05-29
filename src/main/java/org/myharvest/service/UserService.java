package org.myharvest.service;

import org.myharvest.pojo.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void deleteById(Integer id);

    void edit(User user);

    List<User> findAll();

    User findUserById(Long id);

}
