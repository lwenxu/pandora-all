package com.lwen.pandora.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
public class File implements Serializable {
    @Id@GeneratedValue
    private int id;
    private String name;
    private String path;
    private Integer userId;
    private Timestamp createTime;
}
