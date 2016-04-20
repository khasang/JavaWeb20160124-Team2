package io.khasang.webstore.tableService;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public interface TableObjectInterface {
    void setDataSource(DataSource dataSource);

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    List selectWholeTable() throws SQLException;
}