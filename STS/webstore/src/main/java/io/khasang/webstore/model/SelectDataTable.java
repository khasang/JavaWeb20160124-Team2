package io.khasang.webstore.model;

import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectDataTable {
    private JdbcTemplate jdbcTemplate;
    private DatabaseMetaData dbmd = null;
    private ResultSet resultSet = null;

    public SelectDataTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> viewTable(String tableName) {
        String query = "SELECT id, name, amount FROM " + tableName;
        ArrayList<String> list = new ArrayList<String>();
        Statement pStatment = null;
        ResultSet resultSet = null;
        try {
            jdbcTemplate.getDataSource().getConnection().createStatement();
        } catch (Exception e) {
        } finally {
        }
        return list;
    }

    public List<String> dataBaseAllTableName() {
        dbmd = null;
        resultSet = null;
        List<String> list = new ArrayList<String>();
        try {
            jdbcTemplate.getDataSource().getConnection().getMetaData();
        } catch (SQLException e) {
        } finally {
        }
        return list;
    }

    public List<String> getTableColumnName(String tableName) {
        dbmd = null;
        resultSet = null;
        List<String> list = new ArrayList<String>();
        try {
            jdbcTemplate.getDataSource().getConnection().getMetaData();
            resultSet.getString("COLUMN_NAME");
        } catch (SQLException e) {
        } finally {
        }
        return list;
    }
}