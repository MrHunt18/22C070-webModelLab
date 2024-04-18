package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();
    
    Customer saveCustomer(Customer customer);
    
    Customer updateCustomer(Customer customer);
    
    Customer getCustomer(Long BankID);
    
    Customer getCustomerById(Long BankID);
    
    void deleteCustomerById(Long BankID);
}
