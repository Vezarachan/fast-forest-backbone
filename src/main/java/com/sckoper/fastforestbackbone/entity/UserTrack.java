package com.sckoper.fastforestbackbone.entity;

import lombok.Data;

//import org.postgis.Point;
import com.esri.core.geometry.Point;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author Leon Croft
 * 用户轨迹标记点类
 */
@Data
@Table(name = "user_track", catalog = "forestdb_dev", schema = "sde")
@Entity
public class UserTrack {

    @Id
    private Integer objectid;

    private Integer pointId;

    private String username;

    private Timestamp createdAt;

    private Point markPoint;

    private Timestamp uploadedAt;
}
