package com.lwen.pandora.dao;

import com.lwen.pandora.entity.Org;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRepository extends JpaRepository<Org,Integer> {
}
