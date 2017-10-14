package com.tow.spring.jdbc.configuration;

import org.postgresql.ds.common.BaseDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static java.lang.System.out;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfiguration {
    @Bean(name = "datasource")
    public String getDatasource(@Value("${jdbc.url}") String url,
                                @Value("${jdbc.username}") String username,
                                @Value("${jdbc.driverClassName}") String driverClassName,
                                @Value("${jdbc.password}") String password){


        return null;

    }
}
