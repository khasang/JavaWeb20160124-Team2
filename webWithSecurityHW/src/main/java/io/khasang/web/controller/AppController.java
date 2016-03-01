package io.khasang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public ModelAndView hello(){
        ModelAndView model = new ModelAndView();
        return model;
    }
}
