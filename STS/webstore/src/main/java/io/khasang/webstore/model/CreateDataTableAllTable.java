package io.khasang.webstore.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CreateDataTableAllTable {

    private SimpleDriverDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public static String sqlCheck;
    private List<String> listOfNameTables = new ArrayList<String>();

    public void connectionToDB() {
        dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://localhost/webstore");
        dataSource.setPassword("root");
        jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Try to connect to database...");
    }

    public String sqlInsertCheck() {
        try {
                DatabaseMetaData metaData = jdbcTemplate.getDataSource().getConnection().getMetaData();
                ResultSet resultSet = metaData.getTables("webstore", null, null, null);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(3));
                    listOfNameTables.add(resultSet.getString(3));
                }
                resultSet.close();
            System.out.println("Creating tables...");
            jdbcTemplate.execute("DROP TABLE IF EXISTS allTableDB");
            jdbcTemplate.execute("create table allTableDB(Id INT NOT NULL,"
                    + " tName LONGTEXT NOT NULL, description MEDIUMTEXT NULL)");
            for (int i=0; i<listOfNameTables.size(); i++) {
                jdbcTemplate.update("INSERT INTO allTableDB(Id, tName, description) VALUES("
                        + i +", " +"'"+listOfNameTables.get(i)+"'" + ", " + "'table')");
            }
            sqlCheck = "Database updated";
            System.out.println(sqlCheck);
        } catch (Exception e) {
            sqlCheck = "Have error: " + e;
            System.err.println(sqlCheck);
        }
        return sqlCheck;
    }
}
