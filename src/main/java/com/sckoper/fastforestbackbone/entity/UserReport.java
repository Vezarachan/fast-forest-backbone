package com.sckoper.fastforestbackbone.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

//import org.postgis.Point;
import com.esri.core.geometry.Point;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Leon Croft
 * 事件报告类
 */
@Data
@Table(name = "user_report", catalog = "forestdb_dev", schema = "sde")
@Entity
public class UserReport {

    @Id
    private Integer reportId;

    @Column(name = "username")
    private String userName;

    private String eventName;

    private Timestamp createdAt;

    private String reportContent;

    private Timestamp uploadedAt;

    private String eventType;

    private Point eventPosition;

    @ManyToOne(optional = false)
    private User user;
}
