package com.khasang.hello.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserData extends HttpServlet {

    private SimpleDriverDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private List dataList = new ArrayList();
    private String page = "/WEB-INF/views/admin.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("status", "This is protected page!");
        connectionToDB();
        resp.setContentType("text/html;charset=UTF-8");
        getNameOfTableFromTable(req, resp);
    }

    public void connectionToDB() {
        dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://localhost/hello_table");
        dataSource.setPassword("root");
        jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Try to connect to database...");
    }

    public void getNameOfTableFromTable(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultSet set;

        try {
            String sql = "SELECT * from hello_table";
            Statement statement = jdbcTemplate.getDataSource().getConnection().createStatement();
            statement.executeQuery(sql);
            set = statement.getResultSet();
            while (set.next()) {
                dataList.add(set.getString("name"));
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


}
