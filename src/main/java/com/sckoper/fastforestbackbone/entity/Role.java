package com.sckoper.fastforestbackbone.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Leon Croft
 * 系统角色类
 */
@Data
@Table(name = "role_tbl", catalog = "forestdb_dev", schema = "sde")
@Entity
public class Role {

    @Id
    private Integer roleId;

    @Column(unique = true, name = "rolename")
    private String roleName;

    private String description;

    @ManyToMany
    private List<User> users;

    @ManyToMany(targetEntity = Priv.class)
    @JoinTable(name = "role_priv", catalog = "forestdb_dev", schema = "sde", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "privId")})
    private List<Priv> privs;
}
