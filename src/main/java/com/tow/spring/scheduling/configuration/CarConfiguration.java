package com.tow.spring.scheduling.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@PropertySource("classpath:config.properties")
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.tow.spring.scheduling",
        entityManagerFactoryRef = "emf",
        transactionManagerRef = "transactionManager")
@ComponentScan("com.tow.spring.scheduling")
@EnableScheduling
public class CarConfiguration {
    @Bean(destroyMethod = "shutdown")
    public Executor taskScheduler() {
        return Executors.newScheduledThreadPool(5);
    }
    @Bean(name = "emf")
    public LocalContainerEntityManagerFactoryBean emf(
            @Qualifier("dataSource") DataSource dataSource,
            @Value("${hibernate.dialect}") String hibernateDialect,
            @Value("${hibernate.max_fetch_depth}") String hibernateMaxFetchDepth,
            @Value("${hibernate.jdbc.fetch_size}") String hibernateJdbcFetchSize,
            @Value("${hibernate.jdbc.batch_size}") String hibernateJdbcBatchSize,
            @Value("${hibernate.show_sql}") String hibernateShowSql
    ) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("com.tow.spring.scheduling");
        factoryBean.setJpaProperties(new Properties() {{
            put("hibernate.dialect", hibernateDialect);
            put("hibernate.max_fetch_depth", hibernateMaxFetchDepth);
            put("hibernate.jdbc.fetch_size", hibernateJdbcFetchSize);
            put("hibernate.jdbc.batch_size", hibernateJdbcBatchSize);
            put("hibernate.show_sql", hibernateShowSql);
        }});
        return factoryBean;
    }

    @Bean("dataSource")
    public DataSource dataSource(
            @Value("${db.url_tempate}") String urlTemplate,
            @Value("${db.ip}") String dbIp,
            @Value("${db.port}") Integer dbPort,
            @Value("${db.name}") String dbName,
            @Value("${db.user_name}") String dbUserName,
            @Value("${db.password}") String dbPassword,
            @Value("${db.validation_query}") String dbValidationQuery) {

        BasicDataSource dataSourceConfig = new BasicDataSource();
        dataSourceConfig.setDriverClassName("org.postgresql.Driver");

        String url = String.format(urlTemplate, dbIp, dbPort, dbName);

        dataSourceConfig.setUrl(url);
        dataSourceConfig.setUsername(dbUserName);
        dataSourceConfig.setPassword(dbPassword);

        return dataSourceConfig;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(@Autowired EntityManagerFactory factoryBean) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(factoryBean);
//        new org.postgresql.Driver();
        return transactionManager;
    }
}
