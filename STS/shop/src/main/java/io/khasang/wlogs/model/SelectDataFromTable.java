package io.khasang.wlogs.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 134 on 09.02.2016.
 */
public class SelectDataFromTable {
    private String firstItem = "Apples";
    private int firstItemPrice = 100;
    private String secondItem = "Oranges";
    private int secondItemPrice = 200;
    private String result;
    /*НОВАЯ ЧАСТЬ*/
    private List<Item> items;
    SimpleDriverDataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public void select() {
        dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://localhost/webstore");
        dataSource.setPassword("root");
        jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("trying to select");
        items = findAllActors();
    }

    public List<Item> findAllActors() {
        return this.jdbcTemplate.query( "select ID, pName, description from products", new ItemMapper());
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    public List<Item> getItems() {
        return items;
    }

    /*ВНИЗУ СТАРАЯ ЧАСТЬ*/
    public SelectDataFromTable() {
    }

    public String getFirstItem() {
        return firstItem;
    }

    public int getFirstItemPrice() {
        return firstItemPrice;
    }

    public String getSecondItem() {
        return secondItem;
    }

    public int getSecondItemPrice() {
        return secondItemPrice;
    }

    public String getResult() {
        return result;
    }

    public List<String> selectDataFromTable(String tableName) {
        return new ArrayList<String>();
    }
}

final class ItemMapper implements RowMapper<Item> {
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setID(rs.getInt("ID"));
        item.setpName(rs.getString("pName"));
        item.setDescription(rs.getString("description"));
        return item;
    }
}