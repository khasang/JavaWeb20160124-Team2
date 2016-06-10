package io.khasang.webstore.archive;

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

//    public List<Login> getAll() {
//        return this.jdbcTemplate.query("SELECT * FROM logins;",
//                new RowMapper<Login>() {
//                    public Login mapRow(ResultSet result, int i) throws SQLException {
//                        return new Login(
//                                result.getInt("id"),
//                                result.getString("login"),
//                                result.getString("password"),
//                                result.getString("security")
//                        );
//                    }
//                }
//        );
//    }
}
