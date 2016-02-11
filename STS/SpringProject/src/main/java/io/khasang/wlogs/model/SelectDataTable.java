package io.khasang.wlogs.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Technology on 11.02.16.
 */
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
            pStatment = jdbcTemplate.getDataSource().getConnection().createStatement();
            resultSet = pStatment.executeQuery(query);
            while (resultSet.next()) {
                list.add(resultSet.getString("id"));
                list.add(resultSet.getString("name"));
                list.add(resultSet.getString("description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStatment != null) {
                    pStatment.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
