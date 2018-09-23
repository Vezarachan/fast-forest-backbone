package com.sckoper.fastforestbackbone.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 用户实体类
 * @author Leon Croft
 */
@Data
@Entity
@Table(name = "user_tbl", catalog = "forestdb_dev", schema = "sde")
public class User {

    @Id
    @GeneratedValue
    private Integer userId;

    private String userName;

    private String sex;

    private Integer age;

    private String occupation;

    private String phoneNumber;

    private String password;

    private Date lastPasswordResetDate;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "user_role", catalog = "forestdb_dev", schema = "sde", joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<UserReport> userReports;
}
