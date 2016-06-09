package io.khasang.webstore.controller;

import io.khasang.webstore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<ProductPojo> ROW_MAPPER = BeanPropertyRowMapper.newInstance(ProductPojo.class);

    @RequestMapping("/")
    public String welcome(Model model) {
        List<ProductPojo> productHitsList = jdbcTemplate.query("SELECT * FROM products", ROW_MAPPER);
        List<ProductPojo> productRecommendedList = jdbcTemplate.query("SELECT * FROM products", ROW_MAPPER);

        model.addAttribute("pageName", "Название интернет магазина с намёком на сферу деятельности");
        model.addAttribute("productHitsList", productHitsList);
        model.addAttribute("productRecommendedList", productRecommendedList);
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
        model.addAttribute("pageName", "Название товара");

        List<ProductPojo> products = jdbcTemplate.query("SELECT * FROM products WHERE id=?", ROW_MAPPER, id);
        ProductPojo productPojo = DataAccessUtils.singleResult(products);
        model.addAttribute("thisProduct", productPojo);
        return "product";
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String catalog(@RequestParam("id") int id, Model model) {
        List<ProductPojo> productsList = jdbcTemplate.query("SELECT * FROM products", ROW_MAPPER);
        model.addAttribute("pageName", "Название каталога");
        model.addAttribute("productsList", productsList);
        return "catalog";
    }

    @RequestMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("pageName", "Корзина");
        return "cart";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageName", "О нас");
        return "about";
    }

    @RequestMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("pageName", "Контакты");
        return "contacts";
    }

    @RequestMapping("/account")
    public String account(Model model) {
        model.addAttribute("pageName", "Личный кабинет");
        return "account";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("pageName", "Панель администратора");
        return "admin";
    }

    @RequestMapping("/admin/pages")
    public String admin_pages(Model model) {
        model.addAttribute("pageName", "Просмотр страниц");
        return "admin_pages";
    }

    @RequestMapping("/admin/categories")
    public String admin_categories(Model model) {
        model.addAttribute("pageName", "Просмотр категорий");
        return "admin_categories";
    }

    @RequestMapping("/admin/products")
    public String admin_products(Model model) {
        model.addAttribute("pageName", "Просмотр товаров");
        return "admin_products";
    }

    @RequestMapping("/admin/deliveries")
    public String admin_deliveries(Model model) {
        model.addAttribute("pageName", "Просмотр заказов");
        return "admin_deliveries";
    }

    @RequestMapping("/admin/page")
    public String admin_page(@RequestParam("id") int id, Model model) {
        model.addAttribute("pageName", "Изменение страницы");
        return "admin_page";
    }

    @RequestMapping("/admin/category")
    public String admin_category(@RequestParam("id") int id, Model model) {
        model.addAttribute("pageName", "Изменение категории");
        return "admin_category";
    }

    @RequestMapping("/admin/product")
    public String admin_product(@RequestParam("id") int id, Model model) {
        model.addAttribute("pageName", "Изменение товара");
        return "admin_product";
    }

    @RequestMapping("/admin/delivery")
    public String admin_delivery(@RequestParam("id") int id, Model model) {
        model.addAttribute("pageName", "Изменение заказа");
        return "admin_delivery";
    }
}

