package com.lwen.pandora.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
public class Menu implements Serializable {
    @Id@GeneratedValue
    private int id;
    private String name;
    private Timestamp createTime;
    private Integer functionId;
    private String type;
    private int order;
    private String icon;
}
