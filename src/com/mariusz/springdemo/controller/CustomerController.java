package com.mariusz.springdemo.controller;

import com.mariusz.springdemo.dao.CustomerDAO;
import com.mariusz.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {

        List<Customer> customers = customerDAO.getCustomers();

        theModel.addAttribute("customers", customers);

        return "list-customers";
    }

}
