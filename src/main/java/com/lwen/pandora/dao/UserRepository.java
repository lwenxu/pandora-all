package com.lwen.pandora.dao;

import com.lwen.pandora.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
}
