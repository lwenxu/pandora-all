package com.lwen.pandora.dao;

import com.lwen.pandora.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit,Integer> {
}
