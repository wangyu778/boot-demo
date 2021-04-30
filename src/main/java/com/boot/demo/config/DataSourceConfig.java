package com.boot.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author: wy
 * @Date: 2021/4/29 14:34
 * @Description:
 */
@Configuration
public class DataSourceConfig {

    /**
     * 创建 master 数据源
     * @ConfigurationProperties 读取 spring.datasource.master 配置到 HikariDataSource 对象
     */
    @Primary
    @Bean(name = "master")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource ordersDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 创建 slave 数据源
     */
    @Bean(name = "slave")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource usersDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

}
