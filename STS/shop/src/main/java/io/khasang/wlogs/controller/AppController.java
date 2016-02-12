package io.khasang.wlogs.controller;

import io.khasang.wlogs.model.InsertDataTable;
import io.khasang.wlogs.model.Item;
import io.khasang.wlogs.model.SelectDataFromTable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {
    List<Item> products;

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to our best Shop!");
        model.addAttribute("tagline", "The one and only amazing shop system!");
        return "welcome";
    }

    @RequestMapping("/backup")
    public String backup(Model model) {
        model.addAttribute("backup", "Success");
        return "backup";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("admin", "You are number 1!");
        return "admin";
    }

    @RequestMapping("/insert")
    public String instert(Model model) {
        InsertDataTable insertDataTable = new InsertDataTable();
        model.addAttribute("insert", insertDataTable.sqlInsertCheck());
        return "insert";
    }

    @RequestMapping("/select")
    public String select(Model model) {
        SelectDataFromTable selectDataFromTable = new SelectDataFromTable();
        selectDataFromTable.select();
        products = selectDataFromTable.getItems();
        model.addAttribute("items", products);
        model.addAttribute("firstItem", selectDataFromTable.getFirstItem());
        model.addAttribute("firstItemPrice", selectDataFromTable.getFirstItemPrice());
        model.addAttribute("secondItem", selectDataFromTable.getSecondItem());
        model.addAttribute("secondItemPrice", selectDataFromTable.getSecondItemPrice());
        return "select";
    }
}