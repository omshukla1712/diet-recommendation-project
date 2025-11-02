//package com.dietapp.config;
//import org.springframework.context.annotation.*;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan(basePackages = "com.dietapp")
//public class AppConfig {
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("org.postgresql.Driver");
//        ds.setUrl("jdbc:postgresql://localhost:5432/dietdb");
//        ds.setUsername("dietuser");
//        ds.setPassword("dietpass");
//        return ds;
//    }
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
//        factory.setDataSource(dataSource());
//        factory.setPackagesToScan("com.dietapp.model");
//
//        Properties props = new Properties();
//        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        props.put("hibernate.hbm2ddl.auto", "update");
//        props.put("hibernate.show_sql", "true");
//        props.put("hibernate.format_sql", "true");
//
//        factory.setHibernateProperties(props);
//        return factory;
//    }
//
//}
