package com.lwen.pandora.dao;

import com.lwen.pandora.entity.ConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<ConfigEntity,Long> {
}
