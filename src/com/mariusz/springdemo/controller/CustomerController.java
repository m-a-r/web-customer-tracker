package com.mariusz.springdemo.controller;

import com.mariusz.springdemo.entity.Customer;
import com.mariusz.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        List<Customer> customers = customerService.getCustomers();

        theModel.addAttribute("customers", customers);

        return "list-customers";
    }

    @PostMapping("/searchCustomers")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {

        List<Customer> tempCustomer = customerService.searchCustomers(theSearchName);

        theModel.addAttribute("customers", tempCustomer);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@ModelAttribute("customer") Customer theCustomer) {

        return "customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int customerId, Model theModel) {

        Customer customer = customerService.getCustomer(customerId);

        theModel.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("deleteUserId") int deleteUserId) {

        customerService.deleteCustomer(deleteUserId);

        return "redirect:/customer/list";
    }

}
