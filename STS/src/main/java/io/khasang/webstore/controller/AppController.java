package io.khasang.webstore.controller;

import io.khasang.webstore.model.CreateDataTable;
import io.khasang.webstore.model.SelectDataTable;
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

    @RequestMapping("/insertdata")
    public String insertData(Model model) {
        CreateDataTable createDataTable = new CreateDataTable();
        model.addAttribute("insertdata", createDataTable.sqlInsertCheck());
        return "insertdata";
    }

    @RequestMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("menu", "This menu page");
        return "menu";
    }


}