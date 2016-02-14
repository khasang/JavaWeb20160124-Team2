package io.khasang.wlogs.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectDataFromTable {
    private SimpleDriverDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private List<TableObjectInterface> tableObjects;

    public void initConnection() {
        dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://localhost/webstore");
        dataSource.setPassword("root");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<TableObjectInterface> selectWholeTable(TableObjectInterface tableObjectName) {
        tableObjects = new ArrayList<TableObjectInterface>();
        tableObjectName.setDataSource(dataSource);
        tableObjectName.setJdbcTemplate(jdbcTemplate);
        try {
            tableObjects = tableObjectName.selectWholeTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableObjects;
    }
}