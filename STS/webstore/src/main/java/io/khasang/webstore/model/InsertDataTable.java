package io.khasang.webstore.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class InsertDataTable {
    public static String sqlCheck;

    public void sqlInsert() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://localhost/webstore");
        dataSource.setPassword("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("try to update db...");
        try {
            System.out.println("Creating tables");
            jdbcTemplate.execute("DROP TABLE IF EXISTS products");
            jdbcTemplate.execute("create table products(ID INT NOT NULL,"
                    + " pname MEDIUMTEXT NOT NULL, description MEDIUMTEXT NOT NULL)");
            jdbcTemplate.update("INSERT INTO products(ID, pName, description) VALUES(7, 'milk', 'cow')");
            jdbcTemplate.update("INSERT INTO products(ID, pName, description) VALUES(8, 'bread', 'grey')");
            sqlCheck = "db updated";
        } catch (Exception e) {
            sqlCheck = "Have error: " + e;
            System.err.println(sqlCheck);
        }
    }

    public String sqlInsertCheck() {
        InsertDataTable sql = new InsertDataTable();
        sql.sqlInsert();
        return sqlCheck;
    }
}
