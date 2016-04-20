package io.khasang.webstore.config;


import io.khasang.webstore.dao.ProductDAO;
import io.khasang.webstore.model.*;
import io.khasang.webstore.tableService.CreateDataTable;
import io.khasang.webstore.tableService.InsertDataTable;
import io.khasang.webstore.tableService.Productorder;
import io.khasang.webstore.tableService.SelectDataFromTable;
import io.khasang.webstore.web.DropTable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("io.khasang.webstore")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class JavaConfig {

//    @Bean
//    public SimpleDriverDataSource source() {
//        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        dataSource.setUrl("jdbc:mysql://localhost/webstore");
//        return dataSource;
//    }
//
    @Bean
    public JdbcTemplate jdbc(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
        sessionFactoryBean.setHibernateProperties(hibProperties());
        return sessionFactoryBean;
    }

    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    } //TODO iserba 17-21.04.2016 make project using Hibernate JPA (16.04 add hibernate properties and configuration to JavaConfig

    @Bean
    public ProductDAO productDAO(DataSource dataSource) {
        return new ProductDAO(dataSource);
    }

    @Bean
    public ProductDAO viewProducts(DataSource dataSource) {
        return new ProductDAO(dataSource);
    }

    @Bean
    public SelectDataFromTable selectDataFromTable(DataSource dataSource) {
        return new SelectDataFromTable(dataSource);
    }

    @Bean
    public DropTable dropTable() {
        return new DropTable();
    }

    @Bean
    public CustomerCart customerCart() {
        return new CustomerCart();
    }


    @Bean
    public Productorder productorder(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        return new Productorder(dataSource, jdbcTemplate);
    }

    @Bean
    public InsertDataTable insertDataTable(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        return new InsertDataTable(jdbcTemplate, dataSource);
    }

    @Bean
    public CreateDataTable createDataTable(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        return new CreateDataTable(dataSource, jdbcTemplate);
    }

//    TODO if it have not been used by 15.05.2016 - DELETE
//    @Bean
//    public CreateCostsTable createCostsTable() {
//        return new CreateCostsTable();
//    }
//
//    @Bean
//    public MenuHelper menuHelper() {
//        return new MenuHelper();
//    }
}
