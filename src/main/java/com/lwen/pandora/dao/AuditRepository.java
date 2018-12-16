package com.lwen.pandora.dao;

import com.lwen.pandora.entity.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<AuditEntity,Long> {
}
