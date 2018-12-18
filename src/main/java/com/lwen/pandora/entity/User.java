package com.lwen.pandora.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class User implements Serializable {
    @Id@GeneratedValue
    private int id;
    private String username;
    private String nickname;
    private String password;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String state;
    private String email;
    private String phone;
    private Integer avatar;
    private int rank;
    private int score;
    @ManyToMany
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private List<Role> role;
}
