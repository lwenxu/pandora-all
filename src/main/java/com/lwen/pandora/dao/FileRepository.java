package com.lwen.pandora.dao;

import com.lwen.pandora.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity,Long> {
}
