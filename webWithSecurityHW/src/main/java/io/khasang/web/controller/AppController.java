package io.khasang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @RequestMapping(value = {"/hello**", "/"}, method= {RequestMethod.GET})
    public ModelAndView hello(){
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");         // insert this name and get path to jsp
        return model;
    }
}
