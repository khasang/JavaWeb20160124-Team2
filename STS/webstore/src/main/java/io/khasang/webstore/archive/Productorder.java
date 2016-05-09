package io.khasang.webstore.archive;

import io.khasang.webstore.model.TableObjectInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Productorder implements TableObjectInterface {
    private SimpleDriverDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private int id;
    private int orderid;
    private String productorder;
    private int count;
    private int cost;
    private int totalcost;
    private String status;
    private String userid;

    public Productorder() {
    }

    public Productorder(SimpleDriverDataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getProductorder() {
        return productorder;
    }

    public void setProductorder(String productorder) {
        this.productorder = productorder;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(int totalcost) {
        this.totalcost = totalcost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public SimpleDriverDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List selectWholeTable() throws SQLException {
        return this.jdbcTemplate.query("select id, orderid, product, count, cost,  totalcost, status, userid " +
                "from productorder", new ItemMapper());
    }

    public List selectByStatusAndUserid(String status, String userid) {
        return this.jdbcTemplate.query("select * from productorder where status = ? and userid = ?", new ItemMapper(),
                status, userid);
    }
}

final class ItemMapper implements RowMapper<Productorder> {
    public Productorder mapRow(ResultSet rs, int rowNum) throws SQLException {
        Productorder productorder = new Productorder();
        productorder.setId(rs.getInt("id"));
        productorder.setOrderid(rs.getInt("orderid"));
        productorder.setProductorder(rs.getString("productorder"));
        productorder.setCount(rs.getInt("count"));
        productorder.setCost(rs.getInt("cost"));
        productorder.setTotalcost(rs.getInt("totalcost"));
        productorder.setStatus(rs.getString("status"));
        productorder.setUserid(rs.getString("userid"));
        return productorder;
    }
}