package com.mariusz.springdemo.service;

import com.mariusz.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int customerId);

    public void deleteCustomer(int deleteUserId);

    public List<Customer> searchCustomers(String theSearchName);
}
