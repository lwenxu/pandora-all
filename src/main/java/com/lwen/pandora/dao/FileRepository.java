package com.lwen.pandora.dao;

import com.lwen.pandora.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Integer> {
}
