package io.khasang.webstore.model;

import org.apache.commons.logging.Log;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Logins {
    private JdbcTemplate jdbcTemplate;
    private SimpleDriverDataSource dataSource;

    public Logins(SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setDataSource(SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SimpleDriverDataSource getDataSource() {
        return dataSource;
    }

    public List<Login> getAll() {
        String sql = "SELECT * FROM logins;";
        List<Login> logins = this.jdbcTemplate.query(sql, new LoginMapper());

        for (Login login : logins) {
            System.err.println(login.getLogin());
        }
        return logins;
    }

    final private class LoginMapper implements RowMapper<Login> {
        public Login mapRow(ResultSet result, int i) throws SQLException {
            return new Login(
                    result.getInt("id"),
                    result.getString("login"),
                    result.getString("password"),
                    result.getString("security")
            );
        }
    }
}
