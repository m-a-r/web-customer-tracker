package com.mariusz.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/customer")
class CustomerController {

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {

        return "list-customers";
    }

}
