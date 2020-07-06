package com.justin.suppermall.config.snowflake;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

/**
 * @author jr.
 * @date 2020/6/25 21:47
 * @description hibernate自定义id生成器类
 */
public class GenerateId implements IdentifierGenerator, Configurable {

    public SnowflakeIdWorker snowflakeIdWorker;

    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
        snowflakeIdWorker = new SnowflakeIdWorker(0,0);
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        long id = snowflakeIdWorker.nextId();
        return id;
    }
}
