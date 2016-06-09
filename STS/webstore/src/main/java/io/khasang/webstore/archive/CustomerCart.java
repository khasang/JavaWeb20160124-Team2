package io.khasang.webstore.archive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 134 on 23.02.2016.
 */
public class CustomerCart {
    @Autowired
    private SimpleDriverDataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private List<Productorder> productorderList = new ArrayList<Productorder>();

    public CustomerCart() {
    }

    public CustomerCart(List<Productorder> productorderList) {
        this.productorderList = productorderList;
    }

    public List<Productorder> getProductorderList() {
        return productorderList;
    }

    public void setProductorderList(List<Productorder> productorderList) {
        this.productorderList = productorderList;
    }

    public void addProductorderItem(Productorder productorderitem) {

    }

    public List listProductOrder(String status, String userid) {
        productorderList = new Productorder(dataSource, jdbcTemplate).selectByStatusAndUserid(status, userid);
        return productorderList;
    }
}
