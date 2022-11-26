package com.gitlab.nadiatrf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.gitlab.nadiatrf")
@EnableWebMvc
public class AppConfig {
    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.postgresql.jdbc.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/bank");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }
}
