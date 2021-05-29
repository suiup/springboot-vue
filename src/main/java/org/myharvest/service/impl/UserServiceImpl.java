package org.myharvest.service.impl;

import org.myharvest.dao.UserDao;
import org.myharvest.pojo.User;
import org.myharvest.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void edit(User user) {
        userDao.save(user);
    }

    /**
     * demo find all users
     * @return
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findUserById(Long id) {
        User user = userDao.findUserById(id);
        if(user == null){
            return null;
        }
        System.out.println(user);
        String username = user.getUsername();
        System.out.println(username);
        return user;
    }
}
