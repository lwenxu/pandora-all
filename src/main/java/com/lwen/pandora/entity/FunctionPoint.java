package com.lwen.pandora.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "function_point", schema = "pandora", catalog = "")
public class FunctionPoint {
    @Id@GeneratedValue
    private int id;
    private String name;
    private Timestamp createTime;
    private String url;
    @ManyToMany
    @JoinTable(name = "role_function",joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "function_id"))
    private List<Role> role;
}
