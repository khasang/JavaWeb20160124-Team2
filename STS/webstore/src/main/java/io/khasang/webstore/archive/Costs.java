package io.khasang.webstore.archive;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Costs implements TableObjectInterface {
        private SimpleDriverDataSource dataSource;
        private JdbcTemplate jdbcTemplate;
        private int ID;
        private int cost;
        private String pName;

        public Costs() {
        }

        public Costs(SimpleDriverDataSource dataSource, JdbcTemplate jdbcTemplate) {
            this.dataSource = dataSource;
            this.jdbcTemplate = jdbcTemplate;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public String getpName() {
        return pName;
    }

        public void setpName(String pName) {
        this.pName = pName;
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
            return this.jdbcTemplate.query("select costs.ID, cost, pname  from costs, productssss WHERE costs.ID = productssss.ID", new Item());
        }
    }

    class Item implements RowMapper<Costs> {
        public Costs mapRow(ResultSet rs, int rowNum) throws SQLException {
            Costs costs = new Costs();
            costs.setID(rs.getInt("ID"));
            costs.setCost(rs.getInt("cost"));
            costs.setpName(rs.getString("pName"));
            return costs;
        }
    }