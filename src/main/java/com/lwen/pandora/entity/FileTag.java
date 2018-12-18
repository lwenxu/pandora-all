package com.lwen.pandora.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "file_tag", schema = "pandora", catalog = "")
@Data
public class FileTag implements Serializable {
    @Id@GeneratedValue
    private int id;
    private String key;
    private String value;
    private int fileId;
}
