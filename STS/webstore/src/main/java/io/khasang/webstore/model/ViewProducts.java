package io.khasang.webstore.model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Proger on 16.02.2016.
 */
public class ViewProducts {
    private JdbcTemplate jdbcTemplate;
    private SimpleDriverDataSource dataSource;

    public ViewProducts(SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setDataSource(SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SimpleDriverDataSource getDataSource() {
        return dataSource;
    }

    public List<ProductPojo> getAll() {
        List<ProductPojo> products = new ArrayList<ProductPojo>();
        String sql = "SELECT * FROM products";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = (Connection) this.dataSource.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProductPojo product = new ProductPojo();
                product.setID(resultSet.getInt("ID"));
                product.setPname(resultSet.getString("pname"));
                product.setProduct(resultSet.getString("product"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products;
    }
}
