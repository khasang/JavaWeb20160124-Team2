package io.khasang.webstore.controller;

import io.khasang.webstore.model.CreateDataTable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
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
}