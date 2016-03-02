package io.khasang.webstore.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class CreateDataTable {
    public static String sqlCheck;
    JdbcTemplate jdbcTemplate;
    SimpleDriverDataSource dataSource;

    public CreateDataTable() {}
    public CreateDataTable(SimpleDriverDataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }
       public void createTableProducts() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS Products");
            jdbcTemplate.execute("CREATE TABLE products(prodId INT NOT NULL,"
                    + "catId INT NOT NULL,imageId INT NOT NULL, " +
                    " prodName MEDIUMTEXT NOT NULL,prodDesc LONGTEXT," +
                    " PRIMARY KEY (prodId)" +
                    "/*FOREIGN KEY (catId) REFERENCES categories(catId)," +//sql syntax error
                    "FOREIGN KEY (imageId) REFERENCES images(imageId)*/);");
        } catch (Exception e) {
            sqlCheck = "Have error " + e;
            e.printStackTrace();
        }
    }

    public void createTableCategories() {
        try {
            jdbcTemplate.execute("CREATE TABLE Categories(catId INT NOT NULL,"
                    + "catParentId INT NOT NULL,imageId INT NOT NULL, " +
                    " catName MEDIUMTEXT NOT NULL,catDesc LONGTEXT," +
                    " PRIMARY KEY (catId)" +
                    "/* FOREIGN KEY (imageId) REFERENCES images(imageId)," +//sql syntax error
                    " FOREIGN KEY (catParentId) REFERENCES categories(catId)*/);");
        } catch (Exception e) {
            sqlCheck = "Have error " + e;
            e.printStackTrace();
        }
    }

    public void createTableProductMedia() {
        try {
            jdbcTemplate.execute("CREATE TABLE ProductMedia(mediaId INT NOT NULL," +
                    "  prodId INT NOT NULL," +
                    "  imageId INT NOT NULL," +
                    "  PRIMARY KEY (mediaId)" +
                    " /* FOREIGN KEY (imageId) REFERENCES images(imageId)," +//sql syntax error
                    "  FOREIGN KEY (prodId) REFERENCES products(prodId)*/);");
        } catch (Exception e) {
            sqlCheck = "Have error " + e;
            e.printStackTrace();
        }
    }

    public void createTableImages() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS Images");
            jdbcTemplate.execute("CREATE TABLE images(imageId INT  AUTO_INCREMENT," +
                    "  imageSrc  VARCHAR(250) NOT NULL," +
                    "  imageName MEDIUMTEXT NOT NULL," +
                    "  PRIMARY KEY(imageId));");
            sqlCheck = "db updated";
        } catch (Exception e) {
            sqlCheck = "Have error " + e;
            e.printStackTrace();
        }
    }

    public void createTableUsers() {
        try {
            jdbcTemplate.execute("CREATE TABLE Users(userId INT NOT NULL," +
                    " roleId INT NOT NULL," +
                    " userName VARCHAR(45) NOT NULL," +
                    " userLogin VARCHAR(45) NOT NULL," +
                    " userPassword VARCHAR(45) NOT NULL," +
                    " userEmail VARCHAR(45)," +
                    " userPhone VARCHAR(45)," +
                    " userAdress VARCHAR(45)," +
                    " PRIMARY KEY (userId)," +
                    " FOREIGN KEY (roleId) REFERENCES UserRoles(roleId));");
            sqlCheck = "db updated";
        } catch (Exception e) {
            sqlCheck = "Have error " + e;
            e.printStackTrace();
        }
    }

    public void createTableUserRoles() {
        try {
            jdbcTemplate.execute("CREATE TABLE UserRoles(roleId INT NOT NULL," +
                    " roleName VARCHAR(45) NOT NULL," +
                    " PRIMARY KEY (roleId));");
            sqlCheck = "db updated";
        } catch (Exception e) {
            sqlCheck = "Have error " + e;
            e.printStackTrace();
        }
    }

    public void createTableOrders() {
        try {
            jdbcTemplate.execute("CREATE TABLE Orders(orderId INT NOT NULL," +
                    " stateId INT NOT NULL," +
                    " userId INT NOT NULL," +
                    " orderDate VARCHAR(45) NOT NULL," +
                    " PRIMARY KEY (orderId)" +
                    "/* FOREIGN KEY (userId) REFERENCES users(userId)," +//sql syntax error
                    " FOREIGN KEY (stateId) REFERENCES OrderStates(stateId)*/);");
            sqlCheck = "db updated";
        } catch (Exception e) {
            sqlCheck = "Have error " + e;
            e.printStackTrace();
        }
    }

    public void createTableOrderItems() {
        try {
            jdbcTemplate.execute("CREATE TABLE OrderItems(itemId INT NOT NULL," +
                    " prodId INT NOT NULL," +
                    " orderId INT NOT NULL," +
                    " itemQty INT NOT NULL," +
                    " itemFinalPrice DECIMAL NOT NULL," +
                    " PRIMARY KEY (itemId)" +
                    "/* FOREIGN KEY (prodId) REFERENCES products(prodId)," +//sql syntax error
                    " FOREIGN KEY (orderId) REFERENCES orders(orderId)*/);");
            sqlCheck = "db updated";
        } catch (Exception e) {
            sqlCheck = "Have error " + e;
            e.printStackTrace();
        }
    }

    public void createTableOrderStates() {
        try {
            jdbcTemplate.execute("CREATE TABLE OrderStates(stateId INT NOT NULL," +
                    " PRIMARY KEY (stateId));");
            sqlCheck = "db updated";
        } catch (Exception e) {
            sqlCheck = "Have error " + e;
            e.printStackTrace();
        }
    }

    public void createTablePrices() {
        try {
            jdbcTemplate.execute("CREATE TABLE Prices(priceId INT NOT NULL," +
                    "  price DECIMAL NOT NULL," +
                    "  priceSinceData DECIMAL NOT NULL," +
                    "  priceFinishData DECIMAL NOT NULL," +
                    "  prodId INT NOT NULL," +
                    "  PRIMARY KEY (priceId)," +
                    "  FOREIGN KEY(prodId) REFERENCES products(prodId));");
            sqlCheck = "db updated";
        } catch (Exception e) {
            sqlCheck = "Have error " + e;
            e.printStackTrace();
        }
    }

    public void createTableDelivery() {
        try {
            jdbcTemplate.execute("CREATE TABLE Delivery(deliveryId INT NOT NULL," +
                    "  orderId INT NOT NULL," +
                    "  deliveryServiceId DECIMAL NOT NULL," +
                    "  deliveryAddress LONGTEXT NOT NULL," +
                    "  deliveryDate INT NOT NULL," +
                    "  deliveryContactName MEDIUMTEXT NOT NULL," +
                    "  deliveryPhone INT NOT NULL," +
                    "  PRIMARY KEY (deliveryId)" +
                    " /* FOREIGN KEY(orderId) REFERENCES orders(prodId)," +                           //sql syntax error
                    "  FOREIGN KEY(deliveryServiceId) REFERENCES deliveryServiceId(deliveryServiceId)*/);");
            sqlCheck = "db updated";
        } catch (Exception e) {
            sqlCheck = "Have error " + e;
            e.printStackTrace();
        }
    }

    public void createTableDeliveryService() {
        try {
            System.out.println("Creating tables");
            jdbcTemplate.execute("DROP TABLE IF EXISTS products");
            jdbcTemplate.execute("create table products(ID INT NOT NULL,"
                    + " pName MEDIUMTEXT NOT NULL, description LONGTEXT)");
            jdbcTemplate.update("INSERT INTO products(ID, pName, description) VALUES(1, 'apple', 'red')");
            jdbcTemplate.update("INSERT INTO products(ID, pName, description) VALUES(2, 'banan', 'yellow')");
            jdbcTemplate.update("INSERT INTO products(ID, pName, description) VALUES(3, 'bread', null)");
            jdbcTemplate.update("INSERT INTO products(ID, pName, description) VALUES(4, 'milk', 'natural')");
            jdbcTemplate.update("INSERT INTO products(ID, pName, description) VALUES(5, 'becon', 'beef')");
            jdbcTemplate.update("INSERT INTO products(ID, pName, description) VALUES(6, 'bread', 'black')");
            jdbcTemplate.execute("CREATE TABLE DeliveryService(deliveryServiceId INT NOT NULL," +
                    "  deliveryServiceName MEDIUMTEXT NOT NULL," +
                    "  PRIMARY KEY (deliveryServiceId));");
            sqlCheck = "db updated";
        } catch (Exception e) {
            sqlCheck = "Have error " + e;
            e.printStackTrace();
        }
    }

    public String sqlInsertCheck() {
        CreateDataTable sql = new CreateDataTable(dataSource, jdbcTemplate);
        sql.createTableImages();
        sql.createTableCategories();
        sql.createTableProducts();
        sql.createTablePrices();
        sql.createTableProductMedia();
        sql.createTableUserRoles();
        sql.createTableOrderStates();
        sql.createTableUsers();
        sql.createTableOrders();
        sql.createTableOrderItems();
        sql.createTableDelivery();
        sql.createTableDeliveryService();
        return sqlCheck;
    }
}
