package com.lwen.pandora.dao;

import com.lwen.pandora.entity.FunctionPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FunctionPointRepository extends JpaRepository<FunctionPoint,Integer> {
    List<FunctionPoint> findAllByStatus(Integer status);
}
