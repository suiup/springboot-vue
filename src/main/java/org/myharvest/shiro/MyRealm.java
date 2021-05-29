package org.myharvest.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.myharvest.dao.UserDao;
import org.myharvest.pojo.User;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User loginUser = userDao.findUserByUsername(username);
        if(loginUser == null){
            throw new UnknownAccountException("User does not exist!");
        }
        return new SimpleAuthenticationInfo(loginUser,loginUser.getPassword(),getName());
    }
}
