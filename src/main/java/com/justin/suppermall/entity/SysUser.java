package com.justin.suppermall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(generator = "idGenerator")
  @GenericGenerator(name = "idGenerator", strategy = "com.justin.suppermall.config.snowflake.GenerateId")
  private long id;

  @Column(name = "USERNAME")
  @JsonProperty(value = "username")
  private String username;

  @Column(name = "PASSWORD")
  @JsonProperty(value = "password")
  private String password;

  @Column(name = "IS_ENABLE")
  private String isEnable;

}
