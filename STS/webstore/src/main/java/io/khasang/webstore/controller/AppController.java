package io.khasang.webstore.controller;

import io.khasang.webstore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {
    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to our best Shop!");
        model.addAttribute("tagline", "The one and only amazing shop system!");
        return "welcome";
    }

    @RequestMapping("/backup") // todo eborod select current tables and backup with mysqldump Runtime runtime = Runtime.getRuntime();
    // todo "mysqldump eshop -u root -proot -r \"C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\backup.sql\"");
    public String backup(Model model) {
        model.addAttribute("backup", "Success");
        return "backup";
    }

    @RequestMapping("/drop") // todo vzatch input table name and button to drop
    public String drop(Model model) {
        model.addAttribute("drop", "Success");
        return "drop";
    }

    @RequestMapping("/cost") // todo yminee join tables product and cost with id, select all columns
        public String cost(Model model) {
        model.addAttribute("cost", "");
        return "cost";
    }

    @Autowired
    @Qualifier("viewProducts")
    ProductDAO productDAO;

    @RequestMapping("/viewproducts") // todo lselez show all products from table products like table with image and prices
    public String viewProducts(Model model) {
        List<ProductPojo> products = productDAO.getAll();
        model.addAttribute("page_name", "Корзина");
        model.addAttribute("viewproducts", products);
        return "viewproducts";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("admin", "You are number 1!");
        return "admin";
    }

    @RequestMapping("/insertdata")
    public String insertData(Model model) {
        CreateDataTable createDataTable = new CreateDataTable();
        model.addAttribute("insertdata", createDataTable.sqlInsertCheck());
        return "insertdata";
    }

    @RequestMapping("/tableselect")
    public String tableselect(Model model) {
        model.addAttribute("dropdownlist", "Please, select the table");
        return "tableselect";
    }

    @RequestMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("menu", "Menu page text - added to testing!");
        return "menu";
    }


    @RequestMapping("/styleOfPageView")
    public String styleOfPageView(Model model) {
        model.addAttribute("styleOfPageView", "Menu page text - added to testing!");
        return "myPageView";
    }

    @RequestMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("page_name", "Корзина товаров");
        return "cart";
    }

    @RequestMapping("/createtable")
    public String crateTable(Model model) {
        InsertDataTable sql = new InsertDataTable();
        model.addAttribute("createtable", sql.sqlInsertCheck());
        return "createtable";
    }

    @RequestMapping("/deletecurrentorder")
    public String deleteCurrentOrder(Model model) {
        model.addAttribute("deletecurrentorder", ""); //todo vmakar insert to productorder id = current order set cancel.
        return "deletecurrentorder";
    }

    @RequestMapping("/login") // todo mbedr jsp login, select user from table logins with login name.
    public String login(Model model) {
        model.addAttribute("login", "Success");
        return "login";
    }

    @RequestMapping("/front")
    public String front(Model model) {
        model.addAttribute("front", "My page");
        return "front";
    }

    @RequestMapping("/insert")
    public String insert(Model model) {
        InsertDataTable insertDataTable = new InsertDataTable();
        model.addAttribute("insert", insertDataTable.sqlInsertCheck());
        return "insert";
    }

    @RequestMapping("/select") //todo ekarpov select from productorder with id + status in progress and done
    public String select(Model model) {
        SelectDataFromTable selectDataFromTable = new SelectDataFromTable();
        selectDataFromTable.initConnection();
        model.addAttribute("items", selectDataFromTable.selectWholeTable(new Product()));
        return "select";
    }
}

