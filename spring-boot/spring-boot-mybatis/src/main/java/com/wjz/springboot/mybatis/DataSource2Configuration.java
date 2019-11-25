package com.wjz.springboot.mybatis;

import com.wjz.springboot.config.MultipleDataSourceProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.wjz.springboot.mapper.db2", sqlSessionFactoryRef = "db2SqlSessionFactory")
public class DataSource2Configuration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public MultipleDataSourceProperties db2DataSourceProperties() {
        return new MultipleDataSourceProperties();
    }

    @Bean
    public DataSource db2DataSource(@Qualifier("db2DataSourceProperties") MultipleDataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(properties.getType()).build();
    }

    @Bean
    public SqlSessionFactory db2SqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource, @Qualifier("db2DataSourceProperties") MultipleDataSourceProperties dataSourceProperties, MybatisProperties mybatisProperties) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(resolver.getResources(dataSourceProperties.getMapperLocations()));
        factoryBean.setConfigLocation(resolver.getResource(mybatisProperties.getConfigLocation()));
        return factoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager db2TransactionManager(@Qualifier("db2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
