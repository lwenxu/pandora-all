package com.lwen.pandora.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "role_function", schema = "pandora", catalog = "")
@Data
public class RoleFunction implements Serializable {
    @Id@GeneratedValue
    private int id;
    private Integer roleId;
    private Integer functionId;
}
