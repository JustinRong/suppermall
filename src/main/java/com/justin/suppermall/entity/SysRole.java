package com.justin.suppermall.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jr.
 * @date 2020/7/29 16:31
 */
@Data
@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "com.justin.suppermall.config.snowflake.GenerateId")
    private long id;

    @Column(name = "role_name")
    private String roleName;

}
