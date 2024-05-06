package com.iambstha.aop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "activity")
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID activityId;

    @Column(name = "remark")
    private String remark;

    @Column(name = "activity")
    private String activity;

    @Column(name = "created_ts")
    private Timestamp createdTs;

    @Column(name = "created_by")
    private String createdBy;

}
