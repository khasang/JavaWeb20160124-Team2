package io.khasang.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to our best wLogs!");
        model.addAttribute("tagline", "The one and only amazing logs system!");
        return "welcome";
    }

    @RequestMapping("/front")
    public String front(Model model) {
        model.addAttribute("front", "My page");
        return "front";
    }
}