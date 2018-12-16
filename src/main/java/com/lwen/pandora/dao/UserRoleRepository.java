package com.lwen.pandora.dao;

import com.lwen.pandora.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
}
