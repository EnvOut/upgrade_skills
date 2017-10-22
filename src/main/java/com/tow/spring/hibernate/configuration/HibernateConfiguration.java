package com.tow.spring.hibernate.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@ComponentScan(basePackages = "com.tow.spring.hibernate")
@PropertySource("classpath:sql/hibernate/hibernate.properties")
public class HibernateConfiguration {
    @Value("${datasource.driver}")
    private String driverName;
    @Value("${datasource.url}")
    private String datasourceUrl;
    @Value("${datasource.username}")
    private String datasourceUsername;
    @Value("${datasource.password}")
    private String datasourcePassword;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.show_sql}")
    private Boolean hibernateShow_sql;
    @Value("${hibernate.batch.size}")
    private String hibernateHatchSize;
    @Value("${hibernate.current.session.context.class}")
    private String hibernateCurrentSessionContextClass;


    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.tow.spring.hibernate.model"});
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(AvailableSettings.DIALECT, hibernateDialect);
        properties.put(AvailableSettings.SHOW_SQL, hibernateShow_sql);
//        properties.put(AvailableSettings.STATEMENT_BATCH_SIZE, hibernateHatchSize);
//        properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, hibernateCurrentSessionContextClass);
        return properties;
    }
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
}
