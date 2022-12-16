package com.prashant.dao;

import com.prashant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
   // @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);

//    @Query("SELECT u FROM User u WHERE u.password = ?1")
//    User findByPassword(String password);

}
