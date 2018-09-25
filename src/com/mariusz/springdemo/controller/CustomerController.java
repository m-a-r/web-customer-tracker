package com.mariusz.springdemo.controller;

import com.mariusz.springdemo.dao.CustomerDAO;
import com.mariusz.springdemo.entity.Customer;
import com.mariusz.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {

        List<Customer> customers = customerService.getCustomers();

        theModel.addAttribute("customers", customers);

        return "list-customers";
    }

}
