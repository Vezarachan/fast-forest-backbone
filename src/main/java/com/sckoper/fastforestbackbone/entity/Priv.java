package com.sckoper.fastforestbackbone.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Leon Croft
 * 用户权限类
 */
@Data
@Table(name = "priv_tbl", catalog = "forestdb_dev", schema = "sde")
@Entity
public class Priv {

    @Id
    private Integer privId;

    private String privName;

    @ManyToMany
    private List<Role> roles;
}
