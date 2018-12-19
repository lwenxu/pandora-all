package com.lwen.pandora.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder(toBuilder = true)
@Table(name = "function_point", schema = "pandora", catalog = "")
@NoArgsConstructor
@AllArgsConstructor
public class FunctionPoint {
    @Id@GeneratedValue
    private int id;
    private String name;
    private Timestamp createTime;
    private String url;
    private Integer status;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_function",joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "function_id"))
    private List<Role> role;
}
