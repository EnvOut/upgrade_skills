package com.tow.spring.configuration;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableSpringDataWebSupport
@PropertySource("classpath:props/database.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.tow.spring", entityManagerFactoryRef="emf")
public class PostgresConfiguration {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.host}")
    private String host;
    @Value("${spring.datasource.schama}")
    private String schema;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.jpa.database-platform}")
    private String dialect;
    @Value("${spring.jpa.generate-ddl}")
    private Boolean ddl;

    @Bean(name = "dataSource")
    DataSource dataSource() {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName("org.postgresql.Driver");
        driver.setUrl("jdbc:postgresql://localhost:5432/spring");
        driver.setUsername(username);
        driver.setPassword(password);
        return driver;
    }

    @Bean(name = "emf")
    public LocalContainerEntityManagerFactoryBean emf(@Qualifier("dataSource") DataSource dataSource) {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setDatabase(Database.POSTGRESQL);
//        vendorAdapter.setGenerateDdl(true);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan(getClass().getPackage().getName());
//        factory.setDataSource(dataSource);

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPackagesToScan("com.tow.spring");
        emf.setDataSource(dataSource);
        emf.setJpaProperties(new Properties(){{
            put("hibernate.show_sql","true");
//            put("hibernate.hbm2ddl.auto","create");
            put("hibernate.dialect","org.hibernate.dialect.PostgreSQL95Dialect");
        }});
        emf.setPersistenceProvider(new HibernatePersistenceProvider());
        return emf;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(@Qualifier("emf") EntityManagerFactory factoryBean,
                                                    @Qualifier("dataSource") DataSource dataSource) {
        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(factoryBean);
        txManager.setDataSource(dataSource);
        return txManager;
    }
}
