package io.khasang.webstore.archive;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class LocalDataSource {
    private SimpleDriverDataSource dataSource;

    public LocalDataSource() {
        dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://localhost/webstore");
        dataSource.setPassword("root");
    }

    public SimpleDriverDataSource getSource() {
        return dataSource;
    }
}
