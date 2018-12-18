package com.lwen.pandora.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "pandora", catalog = "")
@Data
public class UserRole implements Serializable {
    @Id@GeneratedValue
    private int id;
    private Integer userId;
    private Integer roleId;
    private Integer orgId;
    private Timestamp createTime;
}
