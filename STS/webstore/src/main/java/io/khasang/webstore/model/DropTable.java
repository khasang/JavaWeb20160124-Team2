package io.khasang.webstore.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DropTable extends HttpServlet {

    public static String sqlCheck;
    public String nameTable;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/WEB-INF/views/drop.jsp").include(req, resp);
        nameTable = req.getParameter("name");
        dropSql();
    }

    public void dropSql() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://localhost/webstore");
        dataSource.setPassword("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("try to update db...");
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
