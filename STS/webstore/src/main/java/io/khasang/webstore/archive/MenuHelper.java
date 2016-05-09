package io.khasang.webstore.archive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class MenuHelper extends HttpServlet{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    List<String> pNameOfProducts = new ArrayList<String>();
    List<Integer> idFromProducts = new ArrayList<Integer>();
    public List<String> pNameSelectedFromUser = new ArrayList<String>();

    public void selectInfoFromProductsTableToViewIntoMenu(){
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
                String pName = resultSet.getString("pName"); //new table products - do not created, so I get old values
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
        for (String pNameOfProduct : pNameOfProducts) {
            allpNameOfProducts = allpNameOfProducts + " " + pNameOfProduct + ",";
        }
        return allpNameOfProducts;
    }

    public String getpNameOfProducts(int index){
        return pNameOfProducts.get(index);
    }
    

    public void addSelectedProductToTempList(String productName){
        pNameSelectedFromUser.add(productName);
        System.err.println("size of list "+pNameSelectedFromUser.size());
    }

    public String insertUserSelectedProductToOrderItemTable() {
        return "insert test";
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException{
        responce.setContentType("text/html;charset=UTF-8");
        String currentValue = request.getParameter("name");
        if (currentValue.equals("Get first!")){
            addSelectedProductToTempList("apple");
            System.err.println("apple added");
        }
        if (currentValue.equals("Get two!")){
            addSelectedProductToTempList("banan");
            System.err.println("banan added");
        }
        if (currentValue.equals("Get three!")){
            addSelectedProductToTempList("bread");
            System.err.println("bread added");
        }
        if (currentValue.equals("Get four!")){
            addSelectedProductToTempList("milk");
            System.err.println("milk added");
        }
        if (currentValue.equals("Get five!")){
            addSelectedProductToTempList("becon");
            System.err.println("becon added");
        }
        if (currentValue.equals("Get six!")){
            addSelectedProductToTempList("bread");
            System.err.println("bread added");
        }
    }
}
