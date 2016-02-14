package io.khasang.webstore.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class CreateDataTable {
    public static String sqlCheck;

    public void sqlInsert(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://localhost/webstore");
        dataSource.setPassword("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("try to update db...");
        try{
            System.out.println("creating tables");
                jdbcTemplate.execute("DROP TABLE IF EXISTS products");
                jdbcTemplate.execute("create table products(ID INT NOT NULL, "
                + " pName MEDIUMTEXT NOT NULL, description LONGTEXT)");
            jdbcTemplate.update("INSERT INTO products(ID, pName, description) VALUES(1, 'apple', 'red')");
            jdbcTemplate.update("INSERT INTO products(ID, pName, description) VALUES(2, 'milk', 'natural')");
            jdbcTemplate.update("INSERT INTO products(ID, pName, description) VALUES(3, 'bred', 'null')");
            sqlCheck = "db updated";
        }  catch (Exception e){
            sqlCheck = "have error: "+e;
            System.out.println(sqlCheck);
        }
    }

    public String sqlInsertCheck(){
        CreateDataTable sql = new CreateDataTable();
        sql.sqlInsert();
        return sqlCheck;
    }
}
