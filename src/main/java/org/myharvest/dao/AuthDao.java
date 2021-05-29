package org.myharvest.dao;

import org.myharvest.pojo.Auth;
import org.myharvest.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthDao extends JpaRepository<Auth, Integer> {

    List<Auth> findAll();

    Auth findAuthByAuthId(Integer authId);

    Auth findAuthByAuthName(String authName);

    void deleteByAuthId(Integer authId);

}
