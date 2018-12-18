package com.lwen.pandora.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
public class Config implements Serializable {
    @Id@GeneratedValue
    private int id;
    private String name;
    private String value;
    private String type;
    private String valueType;
    private Integer sort;
    private Timestamp createTime;
    private String remark;
}
