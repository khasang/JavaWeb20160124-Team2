package io.khasang.webstore.controller;

import io.khasang.webstore.model.InsertDataTable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to our best webstore!");
        model.addAttribute("tagline", "The one and only amazing webstore!");
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

    @RequestMapping("/createtable")
    public String crateTable(Model model) {
        InsertDataTable sql = new InsertDataTable();
        model.addAttribute("createtable", sql.sqlInsertCheck());
        return "createtable";
    }

    @RequestMapping("/insert")
    public String insert(Model model) {
        InsertDataTable insertDataTable = new InsertDataTable();
        model.addAttribute("insert", insertDataTable.sqlInsertCheck());
        return "insert";
    }

    @RequestMapping("/select")
    public String select(Model model) {
        SelectDataFromTable selectDataFromTable = new SelectDataFromTable();
        selectDataFromTable.initConnection();
        model.addAttribute("items", selectDataFromTable.selectWholeTable(new Product()));
        return "select";
    }
}