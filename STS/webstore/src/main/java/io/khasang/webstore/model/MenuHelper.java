package io.khasang.webstore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class MenuHelper {
    @Autowired
    private SimpleDriverDataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    List<String> pNameOfProducts = new ArrayList<String>();
    List<Integer> idFromProducts = new ArrayList<Integer>();
    public List<String> pNameSelectedFromUser = new ArrayList<String>();

    private int addImageToTableImage(String url){
        return 0;
    }

    public void selectProductNameFromProductsTableToViewIntoMenu(){
        pNameOfProducts.clear();
        idFromProducts.clear();
        String query = "SELECT ID, pName FROM products";//TODO iserba - when new table products created, correct this
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = jdbcTemplate.getDataSource().getConnection().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Integer id = Integer.parseInt(resultSet.getString("ID")); //new table products - do not created, so I get old values
                String pName = resultSet.getString("pName");//new table products - do not created, so I get old values
                System.err.println(id+pName);
                idFromProducts.add(id);
                pNameOfProducts.add(pName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String getAllpNameOfProducts(){
        String allpNameOfProducts ="";
        for (int i=0;i<pNameOfProducts.size();i++){
            allpNameOfProducts = allpNameOfProducts +" "+pNameOfProducts.get(i)+",";
        }
        return allpNameOfProducts;
    }

    public String getpNameOfProducts(int index){
        return pNameOfProducts.get(index);
    }

    public int getprodIDfrompName(String pName){
        int requredIndex=0;
        for (int i=0;i<pNameOfProducts.size();i++){
            if (pName.equals(pNameOfProducts.get(i))){
                requredIndex = idFromProducts.get(i);
            }
        }
        return requredIndex;
    }

    public int loginBeforeCreateOrder(){
        return 0;
    }

    public void addSelectedProductToTempList(String productName){
        pNameSelectedFromUser.add(productName);
    }

    public String insertUserSelectedProductToOrderItemTable() {
        return "insert test";
    }

    public String sizeProdIdSelectedFromUser() {
        String productsName = "";
        for (int i = 0; i < pNameSelectedFromUser.size(); i++) {
            productsName = productsName+pNameSelectedFromUser.get(i)+", ";
        }
        return productsName;
    }
}
