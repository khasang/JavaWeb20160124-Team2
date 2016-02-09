package io.khasang.wlogs.controller;

import io.khasang.wlogs.model.SelectDataFromTable;
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

    @RequestMapping("/select")
    public String select(Model model) {
        SelectDataFromTable select = new SelectDataFromTable();
        model.addAttribute("firstItem", select.getFirstItem());
        model.addAttribute("firstItemPrice", select.getFirstItemPrice());
        model.addAttribute("secondItem", select.getSecondItem());
        model.addAttribute("secondItemPrice", select.getSecondItemPrice());
        return "select";
    }
}