package io.khasang.webstore.archive;

import io.khasang.webstore.model.ProductPojo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Выбирает товары, цены и изображения
 */
public class ProductDAO {
    private JdbcTemplate jdbcTemplate;
    private SimpleDriverDataSource dataSource;

    public static final String TABLE_NAME = "products";
    public static final String COLUMN_NAME_ID = "ID";
    public static final String COLUMN_NAME_TITLE = "pname";
    public static final String COLUMN_NAME_DESCRIPTION = "productDescription";
    private static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
            COLUMN_NAME_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            COLUMN_NAME_TITLE + " VARCHAR(150) NOT NULL DEFAULT ''," +
            COLUMN_NAME_DESCRIPTION + " LONGTEXT NOT NULL)";

    public ProductDAO(SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        init();
    }

    public void setDataSource(SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SimpleDriverDataSource getDataSource() {
        return dataSource;
    }

    public void init() {
        this.jdbcTemplate.execute(CREATE_SQL);
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
            product.setProduct(resultSet.getString("productDescription"));
            return product;
        }
    }
}
