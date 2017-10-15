package com.tow.spring.jdbc.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.tow.spring.jdbc")
@PropertySource("classpath:jdbc.properties")
public class JdbcConfiguration {
    @Bean(name = "datasource")
    public DriverManagerDataSource getDatasource(@Value("${jdbc.url}") String url,
                                                 @Value("${jdbc.username}") String username,
                                                 @Value("${jdbc.driverClassName}") String driverClassName,
                                                 @Value("${jdbc.password}") String password) {

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setDriverClassName(driverClassName);
        driverManagerDataSource.setPassword(password);

        return driverManagerDataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(@Qualifier("datasource") DriverManagerDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("namedJdbcTemplate")
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(@Qualifier("datasource") DriverManagerDataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
