package com.lwen.pandora.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
public class Audit implements Serializable {
    @Id@GeneratedValue
    private int id;
    private String functionName;
    private Integer userId;
    private String userName;
    private String ip;
    private Timestamp createTime;
    private Byte success;
    private String message;
}
