package com.lwen.pandora.DO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "org", schema = "pandora", catalog = "")
public class OrgEntity {
    private int id;
    private String name;
    private Timestamp createTime;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrgEntity orgEntity = (OrgEntity) o;
        return id == orgEntity.id &&
                Objects.equals(name, orgEntity.name) &&
                Objects.equals(createTime, orgEntity.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createTime);
    }
}
