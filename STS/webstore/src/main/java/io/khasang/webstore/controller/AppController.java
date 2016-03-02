package io.khasang.webstore.controller;

import io.khasang.webstore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AppController {
    List<Productorder> productorders; //Под вопросом

    @Autowired
    @Qualifier("viewProducts")
    ProductDAO productDAO;

    @Autowired
    @Qualifier("createDataTable")
    CreateDataTable createDataTable;

    @Autowired
    @Qualifier("insertDataTable")
    InsertDataTable insertDataTable;

    @Autowired
    @Qualifier("selectDataFromTable")
    SelectDataFromTable selectDataFromTable;

    @Autowired
    @Qualifier("productorder")
    TableObjectInterface tableObjectInterface;

    @Autowired
    @Qualifier("customerCart")
    CustomerCart customerCart;

    @Autowired
    CreateCostsTable createCostsTable;

    @Autowired
    MenuHelper menuHelper;

    @RequestMapping("/")
    public String welcome(Model model) {

        return "welcome";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        if (request.getParameter("error") != null) {
            model.addAttribute("error", "Пользователь не найден");
        }
        if (request.getParameter("logout") != null) {
            model.addAttribute("message", "Вы вышли");
        }
        model.addAttribute("pageName", "Авторизация");
        return "login";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product(@RequestParam("id") int id, Model model) {

        return "product";
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String catalog(@RequestParam("id") int id, Model model) {

        return "catalog";
    }

    @RequestMapping("/cart")
    public String cart(Model model) {

        return "cart";
    }

    @RequestMapping("/about")
    public String about(HttpServletRequest request, Model model) {

        return "about";
    }

    @RequestMapping("/contacts")
    public String contacts(HttpServletRequest request, Model model) {

        return "contacts";
    }

    @RequestMapping("/backup") // todo eborod select current tables and backup with mysqldump Runtime runtime = Runtime.getRuntime();
    // todo "mysqldump eshop -u root -proot -r \"C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\backup.sql\"");
    public String backup(Model model) {
        BackupDatabase backupDatabase = new BackupDatabase();
        model.addAttribute("backup", backupDatabase.backupResultOut());
        return "backup";
    }

    @RequestMapping("/drop")
    public String drop(Model model) {
        return "drop";
    }

    @RequestMapping("/cost") // todo yminee join tables product and cost with id, select all columns
    public String cost(Model model) {
        model.addAttribute("cost", "");
        return "cost";
    }

    // todo lselez show all productorders from table productorders like table with image and prices
    @RequestMapping("/viewproducts")
    // todo lselez show all products from table products like table with image and prices
    public String viewProducts(Model model) {
        List<ProductPojo> products = productDAO.getAll();
        model.addAttribute("page_name", "Список товаров");
        model.addAttribute("viewproducts", products);
        return "viewproducts";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("admin", "You are number 1!");
        return "admin";
    }

    @RequestMapping("/tableselect")
    public String tableselect(Model model) {
        model.addAttribute("dropdownlist", "Please, select the table");
        return "tableselect";
    }

    @RequestMapping("/menu")
    public String menu(Model model) {  
        menuHelper.selectInfoFromProductsTableToViewIntoMenu();
        String textInTopBlock = menuHelper.getAllpNameOfProducts();
        model.addAttribute("menuHelper", menuHelper);
        model.addAttribute("textInTopBlock", "In the WebStore your may buy: " + textInTopBlock);
        model.addAttribute("nameOfFirstBlock", menuHelper.getpNameOfProducts(0));
        model.addAttribute("nameOfSecondBlock", menuHelper.getpNameOfProducts(1));
        model.addAttribute("nameOfThirdBlock", menuHelper.getpNameOfProducts(2));
        model.addAttribute("nameOfFourthBlock", menuHelper.getpNameOfProducts(3));
        model.addAttribute("nameOfFifthlock", menuHelper.getpNameOfProducts(4));
        model.addAttribute("nameOfSixBlock", menuHelper.getpNameOfProducts(5));
        model.addAttribute("nameOfSevenBlock", "Link to see your product");
        model.addAttribute("insert", menuHelper.insertUserSelectedProductToOrderItemTable());
        return "menu";
    }

//    @RequestMapping("/cart")
//    public String cart(Model model) {
//        model.addAttribute("page_name", "Корзина товаров");
//        return "cart";
//    }

    @RequestMapping("/createtable")
    public String crateTable(Model model) {
        model.addAttribute("createtable", createDataTable.sqlInsertCheck());
        return "createtable";
    }

    @RequestMapping("/deletecurrentorder")
    public String deleteCurrentOrder(Model model) {
        model.addAttribute("deletecurrentorder", ""); //todo vmakar insert to productorder id = current order set cancel.
        return "deletecurrentorder";
    }

//    @RequestMapping("/login") // todo mbedr jsp login, select user from table logins with login name.
//    public String login(Model model) {
//        model.addAttribute("login", new Logins(new LocalDataSource().getSource()).getAll());
//        return "login";
//    }

    @RequestMapping("/front")
    public String front(Model model) {
        model.addAttribute("front", "My page");
        return "front";
    }

    @RequestMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("insert", insertDataTable.sqlInsertCheck());
        return "insert";
    }

    //todo done. What's next?
    @RequestMapping(value = "/customercart") //todo ekarpov select from productorder with id + status in progress and done
    public String select(Model model, @RequestParam(value="status", required=false) String status,
                         @RequestParam(value="userid", required=false) String userid) {
        model.addAttribute("items", customerCart.listProductOrder(status, userid));
        return "customercart";
    }

    @Deprecated
    /*Иной способ отображения корзины клиента
    Имеет методы addItem, removeItem и getCartItems
    Корректно пересчитывает quantity одинаковых товаров при добавлении и удалении товара*/
    @RequestMapping("/managecustomercart")
    public String managecustomercart(Model model) {
//        /*пример добавления и удаления элементов из корзины*/
//        deprecatedCustomerCart.addItem("Apple", "Red one", 415);
//        deprecatedCustomerCart.addItem("Apple", "Red one", 415);
//        deprecatedCustomerCart.addItem("Apple", "Red one", 415);
//        deprecatedCustomerCart.addItem("Apple", "Red one", 415);
//        deprecatedCustomerCart.removeItem("Apple");
//        deprecatedCustomerCart.addItem("Orange", "Orange one", 415);
//        deprecatedCustomerCart.addItem("Orange", "Another one", 415);
//        /**/
//        model.addAttribute("cartitems", deprecatedCustomerCart.getCartItems());
        return "managecustomercart";
    }
}

