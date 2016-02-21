package io.khasang.webstore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectDataFromTable {
    @Autowired
    private SimpleDriverDataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private List<TableObjectInterface> tableObjects;

    public SelectDataFromTable(SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SimpleDriverDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
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