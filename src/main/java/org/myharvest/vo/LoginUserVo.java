package org.myharvest.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.beanutils.BeanUtils;
import org.myharvest.pojo.User;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginUserVo {

    private Serializable authorization;
    private Long id;
    private String name;
    private String username;
    private String role;
    private String auth;

    public LoginUserVo(User user, Serializable token) {
        try {
            BeanUtils.copyProperties(this, user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.authorization = token;
        role = "Admin";
        auth = "Add,Delete,Edit,Query";
    }

    public Serializable getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Serializable authorization) {
        this.authorization = authorization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
