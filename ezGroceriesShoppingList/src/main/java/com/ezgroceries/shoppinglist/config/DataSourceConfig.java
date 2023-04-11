package com.ezgroceries.shoppinglist.config;
// This method is commented, because I still don't need a datasource at this part of the task
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
/*
@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("shopping-list.src.main")
    public HikariDataSource hikariDataSource(){
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }
}*/
