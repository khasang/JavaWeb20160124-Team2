package io.khasang.webstore.archive;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DropTable extends HttpServlet {

    private SimpleDriverDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private List<String> listOfNameTables = new ArrayList<String>();
    private List dataList = new ArrayList();

    public static String sqlCheck;
    public String nameTable;
    private String page = "/WEB-INF/views/drop.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Connect to database
        connectionToDB();
        //Create table with all names of tables in database
        sqlInsertCheck();
        resp.setContentType("text/html;charset=UTF-8");
        //Getting name of all tables from table "allTableDB"
        getNameOfTableFromTable(req, resp);
        listOfNameTables.clear();
        dataList.clear();
        //Getting input user value in "text place"
        String currentValueSet = req.getParameter("namet");
        String currentValueText = req.getParameter("name");
        if (!currentValueSet.equals("Select table")) {
            nameTable = currentValueSet;
        } else if (currentValueText != null){
            nameTable = currentValueText;
        }
        //Remove input value
        dropSql();
    }

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

    public void getNameOfTableFromTable(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultSet set;

        try {
            String sql = "SELECT * from allTableDB";
            Statement statement = jdbcTemplate.getDataSource().getConnection().createStatement();
            statement.executeQuery(sql);
            set = statement.getResultSet();
            while (set.next()) {
                dataList.add(set.getString("tName"));
            }
            set.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }
        req.setAttribute("data", dataList);
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        if (dataList != null) {
            dispatcher.forward(req, resp);
        }
    }

    public void dropSql() {
        try {
            System.out.println("Dropping tables");
            System.out.println(nameTable);
            jdbcTemplate.execute("DROP TABLE IF EXISTS " + nameTable);
            sqlCheck = "db droped";
        } catch (Exception e) {
            sqlCheck = "Have error: " + e;
            System.err.println(sqlCheck);
        }
    }
}
