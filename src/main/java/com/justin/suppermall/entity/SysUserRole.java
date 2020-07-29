package com.justin.suppermall.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jr.
 * @date 2020/7/29 16:22
 */
@Data
@Entity
@Table(name = "sys_user_role")
public class SysUserRole implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "com.justin.suppermall.config.snowflake.GenerateId")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;
}
