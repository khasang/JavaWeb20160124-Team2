package io.khasang.webstore.tableService;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

public class InsertDataTable {
    public static String sqlCheck;
    JdbcTemplate jdbcTemplate;
    DataSource dataSource;

    public InsertDataTable(JdbcTemplate jdbcTemplate, DataSource dataSource) {
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
