package org.myharvest.controller;

import org.apache.shiro.SecurityUtils;
import org.myharvest.exception.LoginTimeOutException;
import org.myharvest.pojo.User;

/**
 * ShiroController. get current user
 *
 * @author Zheng Sui
 * @since 2021-04-08
 */
public class ShiroController {

    public User user() {
        User user;
        Object session = SecurityUtils.getSubject().getPrincipal();
        if(session == null){
            throw new LoginTimeOutException();
        }else{
            user = (User) session;
            user.setPassword(null);
            return user;
        }
    }
}
