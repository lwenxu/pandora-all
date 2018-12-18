package com.lwen.pandora.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Role implements Serializable {
    @Id@GeneratedValue
    private int id;
    private String name;
    private Timestamp createTime;
    @ManyToMany(mappedBy = "role")
    private List<User> user;
    @ManyToMany(mappedBy = "role")
    private List<FunctionPoint> functionPoints;
}
