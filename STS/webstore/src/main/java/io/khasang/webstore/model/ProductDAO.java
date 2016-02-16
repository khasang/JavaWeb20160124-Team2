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
 * Выбирает товары, цены и изображения
 */
public class ProductDAO {
    private JdbcTemplate jdbcTemplate;
    private SimpleDriverDataSource dataSource;

    public ProductDAO(SimpleDriverDataSource dataSource) {
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
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return products;
    }
}
