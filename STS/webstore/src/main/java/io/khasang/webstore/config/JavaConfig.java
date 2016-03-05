package io.khasang.webstore.config;


import io.khasang.webstore.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class JavaConfig {

    @Bean
    public SimpleDriverDataSource source() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost/webstore");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbc(SimpleDriverDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public ProductDAO productDAO(SimpleDriverDataSource dataSource) {
        return new ProductDAO(dataSource);
    }

    @Bean
    public ProductDAO viewProducts(SimpleDriverDataSource dataSource) {
        return new ProductDAO(dataSource);
    }

    @Bean
    public SelectDataFromTable selectDataFromTable(SimpleDriverDataSource dataSource) {
        return new SelectDataFromTable(dataSource);
    }

    @Bean
    public DropTable dropTable() {
        return new DropTable();
    }

    @Bean
    public Productorder productorder(SimpleDriverDataSource dataSource, JdbcTemplate jdbcTemplate) {
        return new Productorder(dataSource, jdbcTemplate);
    }

    @Bean
    public CustomerCart customerCart() {
        return new CustomerCart();
    }

    @Bean
    public InsertDataTable insertDataTable(JdbcTemplate jdbcTemplate, SimpleDriverDataSource dataSource) {
        return new InsertDataTable(jdbcTemplate, dataSource);
    }

    @Bean
    public CreateDataTable createDataTable(SimpleDriverDataSource dataSource, JdbcTemplate jdbcTemplate) {
        return new CreateDataTable(dataSource, jdbcTemplate);
    }

    @Bean
    public CreateCostsTable createCostsTable() {
        return new CreateCostsTable();
    }

    @Bean
    public MenuHelper menuHelper() {
        return new MenuHelper();
    }
}
