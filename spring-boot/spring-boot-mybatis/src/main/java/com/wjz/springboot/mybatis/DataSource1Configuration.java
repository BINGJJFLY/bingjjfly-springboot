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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.wjz.springboot.mapper.db1", sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DataSource1Configuration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public MultipleDataSourceProperties db1DataSourceProperties() {
        return new MultipleDataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource db1DataSource(@Qualifier("db1DataSourceProperties") MultipleDataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(properties.getType()).build();
    }

    @Bean
    @Primary
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource, @Qualifier("db1DataSourceProperties") MultipleDataSourceProperties dataSourceProperties, MybatisProperties mybatisProperties) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(resolver.getResources(dataSourceProperties.getMapperLocations()));
        factoryBean.setConfigLocation(resolver.getResource(mybatisProperties.getConfigLocation()));
        return factoryBean.getObject();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager db1TransactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
