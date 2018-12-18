package com.lwen.pandora.dao;

import com.lwen.pandora.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config,Integer> {
}
