package org.myharvest.dao;

import org.myharvest.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    List<User> findAll();

    User findUserById(Long id);

    User findUserByUsername(String username);

    void deleteById(Integer id);

}
