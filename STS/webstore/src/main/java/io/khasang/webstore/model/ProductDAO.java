package io.khasang.webstore.model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
        String sql = "SELECT * FROM products";
        List<ProductPojo> products = this.jdbcTemplate.query(sql, new ProductMapper());
        return products;
    }

    final private class ProductMapper implements RowMapper<ProductPojo> {

        public ProductPojo mapRow(ResultSet resultSet, int i) throws SQLException {
            ProductPojo product = new ProductPojo();
            product.setID(resultSet.getInt("ID"));
            product.setPname(resultSet.getString("pname"));
            product.setProduct(resultSet.getString("product"));
            return product;
        }
    }
}
