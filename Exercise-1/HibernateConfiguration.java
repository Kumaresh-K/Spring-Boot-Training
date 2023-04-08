package com.example.demo;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * It's a Manual Configuration for Hibernate instead of Auto Configuration
 * @author kumareshkaruppusamy
 */

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {
	
    @Autowired
    private Environment environment;
    
    /**
     * Creates the local localSessionFactoryBean using dataSource and hibernateProperties
     * @return localSessionFactoryBean object to create the transaction manager
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
    
    /**
     * Defining the properties for the datasoruce
     * @return dataSource object 
     */
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
        return dataSource;
    }
    
    /**
     * Set the property of the hibernate from the application.properties file
     * @return the property object 
     */
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("spring.jpa.show-sql"));
        properties.put("hibernate.connection.username", environment.getRequiredProperty("spring.datasource.username"));
        properties.put("hibernate.connection.password", environment.getRequiredProperty("spring.datasource.password"));
        properties.setProperty("hibernate.hbm2ddl.auto",environment.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
        return properties;
    }
    
    /**
     * Creation of the transaction manager
     * @param sessionFactory is the object of the session factory class
     * @return the transaction manager for the functionalities for the transactions
     */
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
       HibernateTransactionManager transactionManager = new HibernateTransactionManager();
       transactionManager.setSessionFactory(sessionFactory);
       return transactionManager;
    }
}