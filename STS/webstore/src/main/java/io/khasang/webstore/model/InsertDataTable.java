package io.khasang.webstore.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;

public class InsertDataTable {
    public static String sqlCheck;
    JdbcTemplate jdbcTemplate;
    SimpleDriverDataSource dataSource;

    public InsertDataTable(JdbcTemplate jdbcTemplate, SimpleDriverDataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }
    public void sqlInsert() {
        try {
            jdbcTemplate.update("INSERT INTO products(prodId, catId, imageId, prodName) VALUES(1, 1, 2, 'apple')");
            sqlCheck = "db updated";
        } catch (Exception e) {
            sqlCheck = "Have error: " + e;
            e.printStackTrace();
        }

    }

    public String sqlInsertCheck() {
        InsertDataTable sql = new InsertDataTable(jdbcTemplate, dataSource);
        sql.sqlInsert();
        return sqlCheck;
    }
}
