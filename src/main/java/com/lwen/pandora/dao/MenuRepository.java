package com.lwen.pandora.dao;

import com.lwen.pandora.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity,Long> {
}
