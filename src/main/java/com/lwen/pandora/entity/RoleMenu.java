package com.lwen.pandora.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "role_menu", schema = "pandora", catalog = "")
@Data
public class RoleMenu {
    @Id@GeneratedValue
    private int id;
    private Integer roleId;
    private Integer menuId;
    private Timestamp createTime;
}
