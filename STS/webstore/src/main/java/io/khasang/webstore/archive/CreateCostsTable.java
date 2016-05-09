package io.khasang.webstore.archive;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class CreateCostsTable {
    public static String sqlCheck;

    public void sqlInsert() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://localhost/webstore");
        dataSource.setPassword("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("try to update db...");
        try {
            System.out.println("Creating tables");
            jdbcTemplate.execute("DROP TABLE IF EXISTS costs");
            jdbcTemplate.execute("create table costs(ID INT NOT NULL, cost INT NOT NULL, PRIMARY KEY (ID))");
            jdbcTemplate.update("INSERT INTO costs(ID, cost) VALUES(1, 100)");
            jdbcTemplate.update("INSERT INTO costs(ID, cost) VALUES(2, 89)");
            jdbcTemplate.update("INSERT INTO costs(ID, cost) VALUES(3, 30)");
            jdbcTemplate.update("INSERT INTO costs(ID, cost) VALUES(4, 56)");
            jdbcTemplate.update("INSERT INTO costs(ID, cost) VALUES(5, 200)");
            jdbcTemplate.update("INSERT INTO costs(ID, cost) VALUES(6, 25)");
            jdbcTemplate.update("INSERT INTO costs(ID, cost) VALUES(7, 30)");
            jdbcTemplate.update("INSERT INTO costs(ID, cost) VALUES(8, 25)");
            sqlCheck = "db updated";
        } catch (Exception e) {
            sqlCheck = "Have error: " + e;
            System.err.println(sqlCheck);
        }
    }

    public String sqlInsertCheck() {
        CreateCostsTable sql = new CreateCostsTable();
        sql.sqlInsert();
        return sqlCheck;
    }
}
