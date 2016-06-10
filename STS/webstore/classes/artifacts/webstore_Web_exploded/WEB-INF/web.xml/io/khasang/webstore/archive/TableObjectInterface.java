package io.khasang.webstore.archive;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;
import java.util.List;

public interface TableObjectInterface {
    void setDataSource(SimpleDriverDataSource dataSource);

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    List selectWholeTable() throws SQLException;
}