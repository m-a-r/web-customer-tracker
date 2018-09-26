package com.mariusz.springdemo.dao;

import com.mariusz.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int customerId);

    public void deleteCustomer(int deleteUserId);

    public List<Customer> searchCustomers(String theSearchName);
}
